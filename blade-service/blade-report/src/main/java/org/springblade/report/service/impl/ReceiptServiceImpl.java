package org.springblade.report.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import lombok.extern.slf4j.Slf4j;
import org.springblade.common.utils.AlipayConfig;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.*;
import org.springblade.report.mapper.ReceiptMapper;
import org.springblade.report.sdk.wxpay.WXPayRequest;
import org.springblade.report.sdk.wxpay.WXPayUtil;
import org.springblade.report.service.ReceiptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
public class ReceiptServiceImpl extends BaseServiceImpl<ReceiptMapper, ChargeReceipt> implements ReceiptService {


	private WXPayConfigImpl config = new WXPayConfigImpl();

	/**
	 * 调取支付宝接口 web端支付
	 */
	DefaultAlipayClient alipayClient = new DefaultAlipayClient(
		AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID, AlipayConfig.MERCHANT_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);


	/**
	 * 发票列表
	 *
	 * @param receiptId
	 * @param requestId
	 * @return
	 */
	@Override
	public List<ReceiptList> receiptList(String receiptId, String requestId) {
		return baseMapper.queryReceipt(receiptId, requestId);
	}

	/**
	 * 未退费用清单
	 *
	 * @param requestId
	 * @return
	 */
	@Override
	public QueryNotRefundedRes notRefunded(List<String> requestId) {
		QueryNotRefundedRes queryNotRefundedRes = new QueryNotRefundedRes();
		List<List<QueryNotRefundedVo>> notRefund = new ArrayList<>();
		List<ReceiptVo> receipt = new ArrayList<ReceiptVo>();
		//查询未退费的清单
		for (String id : requestId) {
			notRefund.add(baseMapper.queryNotRefunded(id));
		}
		//查询发票号码
		for (String id : requestId) {
			ReceiptVo receiptVo = new ReceiptVo();
			receiptVo.setOldReceipt(baseMapper.queryReceiptNum(id));
			receipt.add(receiptVo);
		}
		//添加新的发票
		List<String> num = baseMapper.queryReceiptByIdNew(requestId.size());
		if (num.size() != 0) {
			for (int i = 0; i < receipt.size(); i++) {
				if (i <= num.size() && num.size() != 0) {
					String s = num.get(i);
					receipt.get(i).setNewReceipt(s);
					baseMapper.queryReceiptByIdNewStatus(s);
				}
			}
		}
		//返回
		queryNotRefundedRes.setReceiptVo(receipt);
		queryNotRefundedRes.setNotRefund(notRefund);
		return queryNotRefundedRes;
	}

	/**
	 * 发票号列表
	 *
	 * @param requestIds
	 * @return
	 */
	@Override
	public RequestDetailReceiptRes queryRequestDetailReceipt(List<String> requestIds) {
		RequestDetailReceiptRes requestDetailReceiptRes = new RequestDetailReceiptRes();
		//查询当前的发票号
		List<ReceiptVo> receipt = new ArrayList<ReceiptVo>();
		List<List<RequestDetailsVo>> r = new ArrayList<>();
		for (String id : requestIds) {
			ReceiptVo receiptVo = new ReceiptVo();
			receiptVo.setOldReceipt(baseMapper.queryReceiptById(id));
			receipt.add(receiptVo);
			r.add(baseMapper.queryRequestDetails(id));
		}

		List<String> num = baseMapper.queryReceiptByIdNew(requestIds.size());
		if (num.size() != 0) {
			for (int i = 0; i < receipt.size(); i++) {
				if (i <= num.size() && num.size() != 0) {
					String s = num.get(i);
					receipt.get(i).setNewReceipt(s);
					baseMapper.queryReceiptByIdNewStatus(s);
				}
			}
		}
		requestDetailReceiptRes.setReceiptVo(receipt);
		requestDetailReceiptRes.setRequestDetailsVo(r);
		return requestDetailReceiptRes;
	}

	/**
	 * 更新发票状态
	 */
	@Override
	public boolean updateStatue() {
		baseMapper.updateStatue();
		return true;
	}

	/**
	 * 打印发票
	 *
	 * @param receiptVo 发票列表
	 * @param username  操作人名
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean printInvoice(List<ReceiptVo> receiptVo, String username) {
		for (ReceiptVo receipt : receiptVo) {
			//先把之前的发票置为已作废
			baseMapper.queryReceiptByIdNewStatus(receipt.getOldReceipt());
			//baseMapper.updateReceiptStatus(receipt.getOldReceipt());
			ChargeReceipt chargeReceipt = baseMapper.queryReceiptByIds(receipt.getOldReceipt());
			//创建一张新的发票
			String millis = System.currentTimeMillis() + "";
			String substring = millis.substring(5, millis.length());
			chargeReceipt.setId(Long.valueOf(substring));
			chargeReceipt.setReceiptNumber(receipt.getNewReceipt());
			chargeReceipt.setStatus(2);
			baseMapper.createdReceipt(chargeReceipt);
		}
/*
		//发票代码和号码、联次及用途、客户名称、开户银行及账号、商品名称或经营项目、计量单位、数量、单价、大小写金额、开票人、开票日期、开票单位(个人)名称(章)
*/
		//调用打印设备打印d
		return true;
	}

	/**
	 * 退款操作
	 *
	 * @param refundVo 退款Id
	 * @param userName 操作人
	 * @param reason   退款原因
	 * @return
	 */
	@Override
	@Transactional
	public String refund(List<RefundVo> refundVo, String userName, String reason) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		//循环进行退款
		for (RefundVo vo : refundVo) {
			RefundPay pay = baseMapper.queryRefundPay(vo.getRequestId(), vo.getItemId());
			//判断是否是现金支付取反
			String payResponse = null;
			if (!pay.getChannelAccount().equals("现金")) {
				//判断是否是微信支付
				if (pay.getStatus().equals("2")) {
					WxPayRefund wxPayRefund = new WxPayRefund();
					wxPayRefund.setTransactionId(pay.getChannelOrder());
					wxPayRefund.setOutRefundNo(vo.getRequestId());
					String account = String.valueOf(pay.getFeePaid().multiply(new BigDecimal(100)).setScale(0, RoundingMode.DOWN));
					wxPayRefund.setTotalFee(account);
					String refundMoney = String.valueOf(pay.getFeeFinal().multiply(new BigDecimal(100)).setScale(0, RoundingMode.DOWN));
					wxPayRefund.setRefundFee(refundMoney);
					//微信进行退款
					payResponse = WXPayRefund(wxPayRefund);
				} else if (pay.getStatus().equals("3")) {
					//支付宝进行退款
					payResponse = AiliPayRefund(pay.getChannelOrder(), pay.getFeeFinal(), vo.getItemId(), vo.getItemName(), pay.getItemCount(), pay.getFeeItem(), pay.getChannelAccount());
				}
			}
			//判断是否退款成功
			if (!payResponse.equals("success")) {
				Map<String, String> error = new HashMap<String, String>();
				error.put("requestId", vo.getItemId());
				error.put("itemId", vo.getItemId());
				error.put("message", payResponse);
				list.add(error);
				break;
			}
			//改状态
			DecimalMoney decimal = baseMapper.queryRefundMoey(vo.getRequestId());
			baseMapper.updatePayStatus(vo.getRequestId(), new Date(), 4, userName, reason);
			baseMapper.updateChargePay(vo.getRequestId(), new Date(), decimal.getFeeRefund().add(pay.getFeeFinal()), 4, userName, reason);
		}
		if (list.size() != 0) {
			for (Map<String, String> stringMap : list) {
				for (String key : stringMap.keySet()) {
					String value = stringMap.get(key);
					//后续在处理吧
				}
			}
		}
		//没有退款失败的项目
		return "退款成功";
	}

	/**
	 * 退款金额
	 *
	 * @param requestIds
	 * @return
	 */
	@Override
	public InvoiceMoneyVo invoiceMoney(List<String> requestIds) {
		InvoiceMoneyVo invoiceMoney = new InvoiceMoneyVo();
		Integer cash = 0;
		Integer wxPay = 0;
		Integer aliPay = 0;
		for (String id : requestIds) {
			List<Integer> money = baseMapper.queryInvoiceMoney(id);
			if (money.size() >= 1) {
				if (money.get(0) != null) {
					cash += money.get(0);
				}

			}
			if (money.size() >= 2) {
				if (money.get(1) != null) {
					wxPay += money.get(1);
				}
			}
			if (money.size() >= 3) {
				if (money.get(2) != null) {
					aliPay += money.get(2);
				}
			}
		}
		invoiceMoney.setCash(new BigDecimal(cash + ""));
		invoiceMoney.setWxPay(new BigDecimal(wxPay + ""));
		invoiceMoney.setAliPay(new BigDecimal(aliPay + ""));
		invoiceMoney.setTotalMoney(new BigDecimal((cash + wxPay + aliPay) + ""));
		return invoiceMoney;
	}

	/**
	 * 支付宝退款
	 *
	 * @param outTradeNo   商户订单号
	 * @param refundAmount 需要退款的金额 圆角分
	 * @param goods_id     商品id
	 * @param goods_name   商品名称
	 * @param quantity     商品数量
	 * @param price        商品单价
	 * @param trans_in     用户账号
	 * @return
	 */
	public String AiliPayRefund(String outTradeNo, BigDecimal refundAmount, String goods_id, String goods_name, String quantity, BigDecimal price, String trans_in) {
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

		String result = null;
		try {
			/** 调取接口*/
			alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
				+ "\"refund_amount\":\"" + refundAmount + "\","
				+ "\"goods_id\":\"" + goods_id + "\","
				+ "\"goods_name\":\"" + goods_name + "\","
				+ "\"quantity\":\"" + quantity + "\","
				+ "\"price\":\"" + price + "\","
				+ "\"trans_in\":\"" + trans_in + "\"}");
			result = alipayClient.execute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		PayAaliCallBack payAaliCallBack = JSON.parseObject(result, PayAaliCallBack.class);
		alipay_trade_page_refund_response res = payAaliCallBack.getAlipay_trade_page_refund_response();
		if (!res.getCode().equals("10000")) {
			return res.getMsg();
		}
		return "success";
	}

	/**
	 * 微信退款
	 *
	 * @param wxPayRefund
	 * @return
	 */
	public String WXPayRefund(WxPayRefund wxPayRefund) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", config.getAppID());
		map.put("mch_id", config.getMchID());
		map.put("nonce_str", System.currentTimeMillis() + "");
		map.put("transaction_id", wxPayRefund.getTransactionId());
		map.put("out_trade_no", wxPayRefund.getOutTradeNo());
		map.put("out_refund_no", wxPayRefund.getOutRefundNo());
		map.put("total_fee", wxPayRefund.getTotalFee() + "");
		map.put("refund_fee", wxPayRefund.getRefundFee() + "");
		Map<String, String> responseMap = null;
		try {
			map.put("sign", WXPayUtil.generateSignedXml(map, config.getKey()));
			//创建请求
			WXPayRequest wxPayRequest = new WXPayRequest(config);
			String mapToXml = WXPayUtil.generateSignedXml(map, config.getKey());
			String responseXml = wxPayRequest.requestWithCert("https://api.mch.weixin.qq.com/secapi/pay/refund", null, mapToXml, false);
			//3.解析结果
			responseMap = WXPayUtil.xmlToMap(responseXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (responseMap.get("return_code").equals("SUCCESS") && responseMap.get("return_msg").equals("OK")) {
			return "success";
		} else {
			return responseMap.get("return_msg");
		}
	}
}

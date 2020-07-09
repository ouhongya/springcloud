package org.springblade.fee.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.wxpay.sdk.WXPayUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.common.utils.AlipayConfig;
import org.springblade.core.tool.api.R;
import org.springblade.fee.config.WXPayConfigImpl;
import org.springblade.fee.entity.*;
import org.springblade.fee.mapper.FeeMapper;
import org.springblade.fee.service.AlipayService;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.service.WXPayService;
import org.springblade.fee.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;


@RestController
@RequestMapping("api")
@AllArgsConstructor
public class FeeController {

	private FeeService feeService;

	private AlipayService alipayService;

	private WXPayService wXPayService;

	private RedisTemplate redisTemplate;

	private FeeMapper feeMapper;

	/**
	 * 获取患者申请单列表
	 */
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "申请单列表", notes = "传入申请单列表id（数组） request_id_list")
	@PostMapping("/queryapplicationfromlist")
	public R<List<Fee>> queryapplicationfrom(@RequestBody List<Long> request_id_list) {
		List<Fee> queryapplicationfrom = feeService.queryapplicationfrom(request_id_list);
		return R.data(queryapplicationfrom);
	}

	/**
	 * 获取患者项目明细
	 */
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "项目明细", notes = "传入申请单列表id request_id")
	@PostMapping("/queryapplication")
	public R<List<Feedetail>> queryapplication(Long request_id) {
		List<Feedetail> queryapplication = feeService.queryapplication(request_id);
		return R.data(queryapplication);

	}



	/**
	 * 新增申请单
	 */
	@PostMapping("/submitapplicationform")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "新增申请单", notes = "传入Applicationfrom")
	public R submit(@RequestBody RequestChargeInfo requestChargeInfo) {
		return R.status(feeService.submit(requestChargeInfo));
	}

	/**
	 * 修改
	 */
	@PostMapping("/updateapplicationform")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "修改", notes = "传入Applicationfrom")
	public R update(@RequestBody RequestChargeInfo requestChargeInfo) {
		return R.status(feeService.updateApplicationfrom(requestChargeInfo));
	}




	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "删除", notes = "传入申请单(list)id")
	public R remove(@RequestBody List<Long> request_id_list) {
		return R.status(feeService.removeApplicationfrom(request_id_list));
	}



	/**
	 * 新增收费记录
	 */
	@PostMapping("/submitrecordchargelist")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增收费记录", notes = "传入RecordCharge(数组)")
	public R<Long> submitrecordcharge(@RequestBody RecordChargeRequest recordChargeRequest) {
		Long submitrecordcharge = feeService.submitrecordcharge(recordChargeRequest);
		return  R.data(submitrecordcharge);

	}



	/**
	 * 收费列表
	 */
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "收费列表", notes = "传入收费记录id")
	@PostMapping("/querychargefeedetail")
	public R<Map<Long, List<Feedetail>>> querychargefeedetail(Long charge_id) {
		Map<Long, List<Feedetail>> querychargefeedetail = feeService.querychargefeedetail(charge_id);
		return R.data(querychargefeedetail);
	}




	/**
	 * 发起支付
	 */
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "发起支付", notes = "传入收费记录charge_id ，支付方式 channel_id,申请单id加上对应收费项目ids FeeRequest,收费实际金额 fee_paid，是否全选(0全选，1没有全选) checked")
	@PostMapping("/createpay")
	public R<Map<Integer,String>> createpay(Long charge_id, Integer channel_id, @RequestBody List<FeeRequest> feeRequest, BigDecimal fee_paid,Integer checked) {
          Map<Integer,String> map=null;
		switch(channel_id){
			case 1 :
				//现金
				String money = feeService.moneypay(charge_id, feeRequest, fee_paid, checked, channel_id);
				map=new HashMap<>();
				map.put(channel_id,money);
				break; //可选
			case 2 :
				//微信
				String wxmoney  = feeService.wxpay(charge_id, fee_paid,feeRequest,checked);
				map=new HashMap<>();
				map.put(channel_id,wxmoney);
				break; //可选
			case 3 :
				//支付宝
				String alimoney =feeService.getPagePay(charge_id,fee_paid,feeRequest,checked);
				map=new HashMap<>();
				map.put(channel_id,alimoney);
				break; //可选
			case 4 :
				//社保
				break; //可选
			case 5 :
				//银行卡
				break; //可选
		}
		return  R.data(map);
	}



	/**
	 * 手动优惠
	 */
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "手动优惠", notes = "传入手动优惠金额money ，手动优惠原因reason,收费记录表id")
	@PostMapping("/createfavourable")
	public R<Favourable> createfavourable(Double money,String reason,Long id) {
		Favourable createfavourable = feeService.createfavourable(money, reason, id);
		return R.data(createfavourable);
	}


	/**
	 * 修改收费项目状态为可退费
	 */
	@PostMapping("/updateRequestChargeInfo")
	@ApiOperationSupport(order = 10)
	@ApiOperation(value = "修改收费项目状态为可退费", notes = "传入申请单id，收费项目 item_id")
	public R updateRequestChargeInfo(@RequestBody ItemCount itemCount) {
		return R.status(feeService.updateRequestChargeInfo(itemCount));
	}


	/**
	 * 支付宝支付回调
	 */
	@PostMapping("/aLiOrderNotifyResult")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public synchronized String aLiOrderNotifyResult(HttpServletRequest request, String out_trade_no,String buyer_id) throws AlipayApiException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = iter.next();
			String[] values = requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				System.out.println(valueStr);
			}
			map.put(name, valueStr);
		}
		boolean signVerified = false;

		try {
			signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY,"utf-8","RSA2");
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return ("fail");// 验签发生异常,则直接返回失败
		}
		try
		{
			if (signVerified)
			{
				System.out.println("支付宝支付回调验签成功");
				//业务处理
				WxResponse wxResponse = (WxResponse) redisTemplate.boundValueOps(out_trade_no).get();
				if(wxResponse.getChecked() == 0){
					try {
						RecordCharge recordCharge=new RecordCharge();
						recordCharge.setId(wxResponse.getCharge_id());
						recordCharge.setStatus(1);
						feeMapper.updateRecordChargeByStatus(recordCharge);
						List<FeeRequest> feeRequest = wxResponse.getFeeRequest();
						for(FeeRequest feerequest:feeRequest){
							List<Integer> item_id = feerequest.getItem_id();
							Long request_id = feerequest.getRequest_id();
							for(Integer id:item_id){
								ItemCount itemCount = new ItemCount();
								itemCount.setItem_id(id);
								itemCount.setRequest_id(request_id);
								itemCount.setStatus(1);
								feeMapper.updateItemCountByStatus(itemCount);
							}
						}
						ChargePay chargePay = new ChargePay();
						chargePay.setChannel_type_id(3);
						chargePay.setChannel_order(out_trade_no);
						chargePay.setChannel_account(buyer_id);
						chargePay.setCharge_id(wxResponse.getCharge_id());
						chargePay.setFee_paid(wxResponse.getFee_paid());
						chargePay.setPaid_time(new Date());
						byte status=1;
						chargePay.setStatus(status);
						feeMapper.insertChargePay(chargePay);
					}catch (Exception e){
						e.printStackTrace();
					}
				}else if(wxResponse.getChecked() == 1){
					try {
						RecordCharge recordCharge=new RecordCharge();
						recordCharge.setId(wxResponse.getCharge_id());
						recordCharge.setStatus(2);
						feeMapper.updateRecordChargeByStatus(recordCharge);
						List<FeeRequest> feeRequest = wxResponse.getFeeRequest();
						for(FeeRequest feerequest:feeRequest){
							List<Integer> item_id = feerequest.getItem_id();
							Long request_id = feerequest.getRequest_id();
							for(Integer id:item_id){
								ItemCount itemCount = new ItemCount();
								itemCount.setItem_id(id);
								itemCount.setRequest_id(request_id);
								itemCount.setStatus(1);
								feeMapper.updateItemCountByStatus(itemCount);
							}
						}
						ChargePay chargePay = new ChargePay();
						chargePay.setChannel_type_id(3);
						chargePay.setChannel_order(out_trade_no);
						chargePay.setChannel_account(buyer_id);
						chargePay.setCharge_id(wxResponse.getCharge_id());
						chargePay.setFee_paid(wxResponse.getFee_paid());
						chargePay.setPaid_time(new Date());
						byte status=2;
						chargePay.setStatus(status);
						feeMapper.insertChargePay(chargePay);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				//业务处理
				return ("success");
			}else {
				System.out.println("支付宝支付回调验证失败");
				return ("fail");
			}
		}catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
//0/2 * * * * *

	//@Scheduled(cron = "0/2 * * * * *")
	public void timer(){
		ExpiryDate expiryDate = feeMapper.selectExpiryDate(1);
		int valid_quantum = expiryDate.getValid_quantum();
		int i = feeMapper.updateRecordChargeByCreateTime(valid_quantum);
	}

	/**
	 * 微信native支付回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("wxNotify")
	public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 拿到微信回调信息
		InputStream inputStream = request.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		StringBuffer sb = new StringBuffer();
		// 将微信回调信息转为字符串
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		inputStream.close();
		String strXml = sb.toString();
		WXPayConfigImpl config = new WXPayConfigImpl();
		Map<String, String> map = WXPayUtil.xmlToMap(strXml);
		System.out.println(strXml);

		// 获取业务信息
		String outTradeNo = map.get("out_trade_no");
		String totalFee = map.get("total_fee");
		String appId = map.get("appid");
		String mchId = map.get("mch_id");
		String transactionId = map.get("transaction_id");
		String resultCode = map.get("result_code");
		String attach = map.get("attach");

		// 验签
		boolean signatureValid = WXPayUtil.isSignatureValid(strXml, config.getKey());
		// todo 这里写代码
        /* 实际验证过程建议商户务必添加以下校验：
            1、需要验证该通知数据中的 out_trade_no 是否为商户系统中创建的订单号
            2、判断 total_fee 是否确实为该订单的实际金额（即商户订单创建时的金额）
        */
		PrintWriter writer = response.getWriter();
		// 判断签名是否正确
		if (signatureValid) {
			// 判断回调信息是否成功
			if ("SUCCESS".equals(map.get("result_code"))) {
				//业务处理
				WxResponse wxResponse = (WxResponse) redisTemplate.boundValueOps(outTradeNo).get();
				if(wxResponse.getChecked() == 0){
					try {
						RecordCharge recordCharge=new RecordCharge();
						recordCharge.setId(wxResponse.getCharge_id());
						recordCharge.setStatus(1);
						feeMapper.updateRecordChargeByStatus(recordCharge);
						List<FeeRequest> feeRequest = wxResponse.getFeeRequest();
						for(FeeRequest feerequest:feeRequest){
							List<Integer> item_id = feerequest.getItem_id();
							Long request_id = feerequest.getRequest_id();
							for(Integer id:item_id){
								ItemCount itemCount = new ItemCount();
								itemCount.setItem_id(id);
								itemCount.setRequest_id(request_id);
								itemCount.setStatus(1);
								feeMapper.updateItemCountByStatus(itemCount);
							}
						}
						ChargePay chargePay = new ChargePay();
						chargePay.setChannel_type_id(2);
						chargePay.setChannel_order(outTradeNo);
						chargePay.setCharge_id(wxResponse.getCharge_id());
						chargePay.setFee_paid(wxResponse.getFee_paid());
						chargePay.setPaid_time(new Date());
						byte status=1;
						chargePay.setStatus(status);
						feeMapper.insertChargePay(chargePay);
					}catch (Exception e){
						e.printStackTrace();
					}
				}else if(wxResponse.getChecked() == 1){
					try {
						RecordCharge recordCharge=new RecordCharge();
						recordCharge.setId(wxResponse.getCharge_id());
						recordCharge.setStatus(2);
						feeMapper.updateRecordChargeByStatus(recordCharge);
						List<FeeRequest> feeRequest = wxResponse.getFeeRequest();
						for(FeeRequest feerequest:feeRequest){
							List<Integer> item_id = feerequest.getItem_id();
							Long request_id = feerequest.getRequest_id();
							for(Integer id:item_id){
								ItemCount itemCount = new ItemCount();
								itemCount.setItem_id(id);
								itemCount.setRequest_id(request_id);
								itemCount.setStatus(1);
								feeMapper.updateItemCountByStatus(itemCount);
							}
						}
						ChargePay chargePay = new ChargePay();
						chargePay.setChannel_type_id(2);
						chargePay.setChannel_order(outTradeNo);
						chargePay.setCharge_id(wxResponse.getCharge_id());
						chargePay.setFee_paid(wxResponse.getFee_paid());
						chargePay.setPaid_time(new Date());
						byte status=2;
						chargePay.setStatus(status);
						feeMapper.insertChargePay(chargePay);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				//业务处理
				String noticeStr = setXML("SUCCESS", "");
				writer.write(noticeStr);
				writer.flush();
			}
		} else {
			// 通知微信订单处理失败
			String noticeStr = setXML("FAIL", "");
			writer.write(noticeStr);
			writer.flush();
		}
	}


	private static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
	}



	/**
	 * 现金支付
	 * @param
	 * @param
	 * @throws
	 */
	@RequestMapping("cashpay")
	public R<String> cashpay(String outTradeNo) {


		return R.data("现金收费成功!");
	}

}

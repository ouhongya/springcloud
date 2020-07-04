package org.springblade.fee.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.wxpay.sdk.WXPayUtil;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.common.utils.AlipayConfig;
import org.springblade.core.tool.api.R;
import org.springblade.fee.config.WXPayConfigImpl;
import org.springblade.fee.entity.RecordChargeRequest;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.service.AlipayService;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.service.WXPayService;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.Feedetail;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api")
@AllArgsConstructor
public class FeeController {

	private FeeService feeService;

	private AlipayService alipayService;

	private WXPayService wXPayService;




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
	@PostMapping("/queryapplication")
	public R<Map<Long, List<Feedetail>>> querychargefeedetail(Long charge_id) {
		Map<Long, List<Feedetail>> querychargefeedetail = feeService.querychargefeedetail(charge_id);
		return R.data(querychargefeedetail);
	}




	/**
	 * 发起支付
	 */
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "发起支付", notes = "传入收费记录charge_id ，支付方式 channel_id")
	@PostMapping("/createpay")
	public R createpay(Long charge_id,Integer channel_id) {
//		feeService.createpay(charge_id,channel_id);
		return null;
	}



	/**
	 * 支付宝 web 订单支付
	 */
	@GetMapping("getPagePay")
	public R<Map<Object, Object>> getPagePay() throws Exception{
		/** 模仿数据库，从后台调数据*/
		String outTradeNo = "19960310621211";
		Integer totalAmount = 1;
		String subject = "苹果28";

		String pay = alipayService.webPagePay(outTradeNo, totalAmount, subject);
		System.out.println(pay);

		Map<Object, Object> pays = new HashMap<>();
		pays.put("pay", pay);

		return R.data(pays);
	}



	/**
	 * 支付宝支付回调
	 */
	@PostMapping("/aLiOrderNotifyResult")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public synchronized String aLiOrderNotifyResult(HttpServletRequest request, String out_trade_no,String trade_no,String trade_status,HttpServletResponse response) throws AlipayApiException, IOException {
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
				// todo 根据不同业务类型处理不同业务

				// 通知微信订单处理成功
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
	 * 微信native支付
	 * @param
	 * @param
	 * @throws Exception
	 */
	@RequestMapping("wxpay")
	public R<String> wxpay(String outTradeNo) {
		String totalFee="";
		String body="";
		String productId="";
		String attach="";
		String code =null;
		try {
			code=wXPayService.wxUnifiedOrder(outTradeNo, totalFee, body, productId, attach);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("微信支付失败！");
			return R.fail("微信支付失败！");
		}

		return R.data(code);
	}

	/**
	 * 现金支付
	 * @param
	 * @param
	 * @throws
	 */
	@RequestMapping("cashpay")
	public R<String> cashpay(String outTradeNo) {

		return R.data("现金收费成功！");
	}

}

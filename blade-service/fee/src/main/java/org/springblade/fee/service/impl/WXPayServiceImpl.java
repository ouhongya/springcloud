package org.springblade.fee.service.impl;


import com.github.wxpay.sdk.WXPay;
import org.springblade.fee.config.WXPayConfigImpl;
import org.springblade.fee.service.WXPayService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WXPayServiceImpl implements WXPayService {


	@Override
	public String wxUnifiedOrder(String outTradeNo, String totalFee, String body, String productId, String attach) throws Exception {

		WXPayConfigImpl config = null;
		WXPay wxpay = null;
		config = new WXPayConfigImpl();
		// 异步通知地址
		String notifyUrl = config.getNotifyUrl();
		// 使用沙箱环境
		// wxpay = new WXPay(config, WXPayConstants.SignType.MD5, true);
		// 默认使用MD5，不使用沙箱环境
		wxpay = new WXPay(config);
		Map<String, String> data = new HashMap<String, String>();
		// 商品描述
		data.put("body", body);
		// 商户订单号
		data.put("out_trade_no", outTradeNo);
		// 标价金额
		data.put("total_fee", totalFee);
		// 产品id
		data.put("product_id", productId);
		// 终端IP:调用微信支付API的机器IP
		data.put("spbill_create_ip", "221.12.4.52");
		// 交易类型:此处指定为扫码支付
		data.put("trade_type", "NATIVE");
		// 异步通知 url
		data.put("notify_url", notifyUrl);
		// 自定义参数
		data.put("attach", attach);
		Map<String, String> resp = null;
		try {
			resp = wxpay.unifiedOrder(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String codeUrl = resp.get("code_url");
		System.out.println("============= 微信返回结果 =============");
		System.out.println(resp);
		return codeUrl;

	}
}

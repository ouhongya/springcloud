package org.springblade.fee.service;



public interface WXPayService {

	/**
	 * 微信扫码下单 native
	 * @param outTradeNo
	 * @param totalFee
	 * @param body
	 * @param productId
	 * @param attach 自定义参数，通知中原样返回。
	 * @return
	 * @throws Exception
	 */
	 String wxUnifiedOrder(String outTradeNo, String totalFee, String body, String productId, String attach) throws Exception;


}

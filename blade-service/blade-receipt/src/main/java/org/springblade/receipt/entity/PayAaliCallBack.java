package org.springblade.receipt.entity;

import java.math.BigDecimal;

public  class  PayAaliCallBack {
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	private alipay_trade_page_refund_response alipay_trade_page_refund_response;

	public org.springblade.receipt.entity.alipay_trade_page_refund_response getAlipay_trade_page_refund_response() {
		return alipay_trade_page_refund_response;
	}

	public void setAlipay_trade_page_refund_response(org.springblade.receipt.entity.alipay_trade_page_refund_response alipay_trade_page_refund_response) {
		this.alipay_trade_page_refund_response = alipay_trade_page_refund_response;
	}
}



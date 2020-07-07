package org.springblade.receipt.entity;

import java.math.BigDecimal;

public class PayAaliCallBack {

	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	class alipay_trade_page_refund_response {
		private String code;
		private String msg;
		private String trade_no;
		private String out_trade_no;
		private String out_request_no;
		private BigDecimal refund_amount;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getTrade_no() {
			return trade_no;
		}

		public void setTrade_no(String trade_no) {
			this.trade_no = trade_no;
		}

		public String getOut_trade_no() {
			return out_trade_no;
		}

		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}

		public String getOut_request_no() {
			return out_request_no;
		}

		public void setOut_request_no(String out_request_no) {
			this.out_request_no = out_request_no;
		}

		public BigDecimal getRefund_amount() {
			return refund_amount;
		}

		public void setRefund_amount(BigDecimal refund_amount) {
			this.refund_amount = refund_amount;
		}
	}

	alipay_trade_page_refund_response alipay_trade_page_refund_response;

	public org.springblade.receipt.entity.alipay_trade_page_refund_response getAlipay_trade_page_refund_response() {
		return alipay_trade_page_refund_response;
	}

	public void setAlipay_trade_page_refund_response(org.springblade.receipt.entity.alipay_trade_page_refund_response alipay_trade_page_refund_response) {
		this.alipay_trade_page_refund_response = alipay_trade_page_refund_response;
	}
}


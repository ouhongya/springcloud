package org.springblade.report.entity;


import java.math.BigDecimal;

public class DecimalMoney {

	private BigDecimal feeRefund;

	private BigDecimal feePaid;

	public BigDecimal getFeeRefund() {
		return feeRefund;
	}

	public void setFeeRefund(BigDecimal feeRefund) {
		this.feeRefund = feeRefund;
	}

	public BigDecimal getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(BigDecimal feePaid) {
		this.feePaid = feePaid;
	}
}

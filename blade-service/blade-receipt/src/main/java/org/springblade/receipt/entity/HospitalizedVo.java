package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class HospitalizedVo {
	@ApiModelProperty(value = "续费单号")
	private String requestId;
	@ApiModelProperty(value = "预交金金额")
	private String feePaid;
	@ApiModelProperty(value = "续费时间")
	private String paidTime;
	@ApiModelProperty(value = "合计缴费")
	private BigDecimal totalMoney;
	@ApiModelProperty(value = "已用费用")
	private BigDecimal payMoney;
	@ApiModelProperty(value = "剩余费用")
	private BigDecimal remainingMoney;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(String feePaid) {
		this.feePaid = feePaid;
	}

	public String getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(String paidTime) {
		this.paidTime = paidTime;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getRemainingMoney() {
		return remainingMoney;
	}

	public void setRemainingMoney(BigDecimal remainingMoney) {
		this.remainingMoney = remainingMoney;
	}
}

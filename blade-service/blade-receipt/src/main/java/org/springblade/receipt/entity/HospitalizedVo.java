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
}

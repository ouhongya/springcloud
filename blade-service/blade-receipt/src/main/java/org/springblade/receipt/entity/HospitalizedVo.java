package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;

public class HospitalizedVo {
	@ApiModelProperty(value = "续费单号")
	private String requestId;
	@ApiModelProperty(value = "预交金金额")
	private String feePaid;
	@ApiModelProperty(value = "续费时间")
	private String paidTime;
}

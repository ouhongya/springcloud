package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReceiptList {
	/**
	 * 发票号
	 */
	@ApiModelProperty(value = "发票号")
	private String id;
	/**
	 * 费别
	 */
	@ApiModelProperty(value = "费别")
	private String text;
	/**
	 * 科室
	 */
	@ApiModelProperty(value = "科室")
	private Integer deptId;
	/**
	 * 医生
	 */
	@ApiModelProperty(value = "医生")
	private Integer doctorId;
}


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
	private Integer id;
	/**
	 * 费别
	 */
	@ApiModelProperty(value = "费别")
	private String text;
	/**
	 * 科室
	 */
	@ApiModelProperty(value = "科室")
	private String dept_id;
	/**
	 * 医生
	 */
	@ApiModelProperty(value = "医生")
	private String doctor_id;
	/**
	 * 应收
	 */
	@ApiModelProperty(value = "应收")
	private BigDecimal totalMoney;
	/**
	 * 优惠金额
	 */
	@ApiModelProperty(value = "优惠金额")
	private BigDecimal discountMoney;
	/**
	 * 统筹
	 */
	@ApiModelProperty(value = "统筹")
	private BigDecimal totalDiscountMoney;
	/**
	 * 实收
	 */
	@ApiModelProperty(value = "实收")
	private BigDecimal money;
}


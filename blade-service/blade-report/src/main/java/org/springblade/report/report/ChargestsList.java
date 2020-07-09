package org.springblade.report.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author create by
 * @date 2020/7/3-15:53
 */
@Data
public class ChargestsList {

	/**
	 * 支付方式id
	 */
	@ApiModelProperty(value = "支付方式id")
	private Long channelTypeId;

	/**
	 * 支付方式名称
	 */
	@ApiModelProperty(value = "支付方式名称")
	private String text;

	/**
	 * 支付方式显示颜色
	 */
	@ApiModelProperty(value = "支付方式显示颜色")
	private String color;


	/**
	 * 分类统计-金额
	 */
	@ApiModelProperty(value = "分类统计-金额")
	private BigDecimal payTypeMoney;

	/**
	 * 退费总金额
	 */
	@ApiModelProperty(value = "退费总金额")
	private BigDecimal refund;

	/**
	 * 实收总金额
	 */
	@ApiModelProperty(value = "实收总金额")
	private BigDecimal totalMoney;
	/**
	 * 实收上缴总金额
	 */
	@ApiModelProperty(value = "实收上缴总金额")
	private BigDecimal actuallyPay;


}

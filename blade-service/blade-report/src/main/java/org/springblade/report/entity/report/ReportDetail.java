package org.springblade.report.entity.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author create by
 * @date 2020/7/4-16:16
 */
@Data
public class ReportDetail {

	/**
	 * 收费记录id
	 */
	@ApiModelProperty(value = "收费记录id")
	private Integer id;

	/**
	 * 费用类别
	 */
	@ApiModelProperty(value = "费用类别")
	private String costCategory;
	/**
	 * 统计类型-申请单类别
	 */

	@ApiModelProperty(value = "统计类型-申请单类别")
	private String requestType;
	/**
	 * 收费创建时间
	 */
	@ApiModelProperty(value = "收费创建时间")
	private Date createTime;
	/**
	 * 支付完成时间
	 */
	@ApiModelProperty(value = "支付完成时间")
	private Date paidTime;

	/**
	 * 应收费用
	 */
	@ApiModelProperty(value = "应收费用")
	private BigDecimal chargeable;
	/**
	 * 优惠费用
	 */
	@ApiModelProperty(value = "优惠费用")
	private BigDecimal discountCost;
	/**
	 * 实收费用
	 */
	@ApiModelProperty(value = "实收费用")
	private BigDecimal actuallyPay;
	/**
	 * 退费金额
	 */
	@ApiModelProperty(value = "退费金额")
	private BigDecimal feeRefund;
	/**
	 * 收费人员id
	 */
	@ApiModelProperty(value = "收费人员id")
	private Integer tollCollectorId;
	/**
	 * 科室id
	 */
	@ApiModelProperty(value = "科室id")
	private Long deptId;
	/**
	 * 支付方式
	 */
	@ApiModelProperty(value = "支付方式")
	private String paymentMethod;

	/**
	 * 是否上交财务
	 */
	@ApiModelProperty(value = "是否上交财务")
	private Integer turnStatus = 0;


	/**
	 * 应收费用
	 */
	@ApiModelProperty(value = "应收费用")
	private Integer totalChargeable;
	/**
	 * 优惠费用
	 */
	@ApiModelProperty(value = "优惠费用")
	private Integer totalDiscountCost;
	/**
	 * 实收费用
	 */
	@ApiModelProperty(value = "实收费用")
	private Integer totalActuallyPay;


	/**
	 * 预览统计申请单类别数量
	 */
	@ApiModelProperty(value = "预览统计申请单类别数量")
	private Integer requestTypeCount;
	/**
	 * 预览统计应收费用
	 */
	@ApiModelProperty(value = "预览统计应收费用")
	private Integer sumChargeable;
	/**
	 * 预览统计优惠费用
	 */
	@ApiModelProperty(value = "预览统计优惠费用")
	private Integer sumDiscountCost;
	/**
	 * 预览统计实收费用
	 */
	@ApiModelProperty(value = "预览统计实收费用")
	private Integer sumActuallyPay;
}

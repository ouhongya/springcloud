package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestDetailsReceiptRes {
	@ApiModelProperty(value = "申请单号Id")
	private String requestId;
	@ApiModelProperty(value = "收费项目Id")
	private String itemId;
	@ApiModelProperty(value = "项目类别id")
	private String itemTypeId;
	@ApiModelProperty(value = "数量")
	private String itemCount;
	@ApiModelProperty(value = "发票状态: 0：未启用 1：已启用 2：已开票 3：已退票 4：已作废")
	private String status;

	@ApiModelProperty(value = "支付状态:0  待支付1  支付完成2  部分支付3  可退款4  有退款 5  作废")
	private String payStatus;

	@ApiModelProperty(value = "总金额")
	private BigDecimal totalMoney;

	@ApiModelProperty(value = "退费金额")
	private BigDecimal refundMoney;

	@ApiModelProperty(value = "支付金额")
	private BigDecimal payMoney;

	@ApiModelProperty(value = "实收费用")
	private BigDecimal feeFinal;

	@ApiModelProperty(value = "优惠费用")
	private BigDecimal feeFavor;

	@ApiModelProperty(value = "项目费用")
	private BigDecimal feeItem;

	@ApiModelProperty(value = "开单医生id")
	private BigDecimal doctorId;

	@ApiModelProperty(value = "申请单类别")
	private BigDecimal requestType;

	@ApiModelProperty(value = "开单科室ID")
	private BigDecimal deptId;

}

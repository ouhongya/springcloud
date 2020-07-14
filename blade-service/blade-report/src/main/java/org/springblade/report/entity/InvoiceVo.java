package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvoiceVo {
	@ApiModelProperty(value = "发票号")
	private String receiptNumber;
	@ApiModelProperty(value = "应结算金额")
	private BigDecimal totalMoney;
	@ApiModelProperty(value = "实收金额")
	private BigDecimal payMoney;
	@ApiModelProperty(value = "收费员")
	private Integer tollCollectorId;
	@ApiModelProperty(value = "发票状态: 0：未启用 1：已启用 2：已开票 3：已退票 4：已作废")
	private Integer status;
	@ApiModelProperty(value = "计算日期")
	private Date paidTime;
	@ApiModelProperty(value = "医生")
	private String doctorId;
	@ApiModelProperty(value = "退费费用")
	private BigDecimal refundMoney;
	@ApiModelProperty(value = "总合计缴费")
	private BigDecimal totalAccoutMoney;
	@ApiModelProperty(value = "总退费费用")
	private BigDecimal refundAccoutMoney;
	@ApiModelProperty(value = "总实收费用")
	private BigDecimal payAccoutMoney;

}

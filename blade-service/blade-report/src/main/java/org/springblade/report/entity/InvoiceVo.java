package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvoiceVo {
	@ApiModelProperty(value = "发票号")
	private String receiptMumber;
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

}

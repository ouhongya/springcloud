package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RequestDetailsVo {
	@ApiModelProperty(value = "申请单id")
	private String requestId;
	@ApiModelProperty(value = "项目类别")
	private String itemId;
	@ApiModelProperty(value = "数量")
	private String num;
	@ApiModelProperty(value = "执行科室")
	private String dockerId;
	@ApiModelProperty(value = "实收费用")
	private String payMoney;
	@ApiModelProperty(value = "缴费状态")
	private String status;
	@ApiModelProperty(value = "发票号")
	private String receiptNumber;
}

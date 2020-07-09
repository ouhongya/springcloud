package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundProject {

	@ApiModelProperty(value = "收费项目id (复合主键2)")
	private String itemId;
	@ApiModelProperty(value = "收费项目id (收费项目类型id)")
	private String itemType;
	@ApiModelProperty(value = "数量")
	private Integer itemCount;
	@ApiModelProperty(value = "用户支付订单号:该次支付在第三方平台的订单号,支付渠道为现金时该项为空")
	private String channelOrder;
	@ApiModelProperty(value = "用户支付账户:银行卡账号,第三方支付账号,支付渠道为现金时直接填写:现金")
	private String channelAccount;
	@ApiModelProperty(value = "fee_paid")
	private BigDecimal feePaid;
}

package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecordCharge extends BaseEntity implements Serializable {

	/**
	 * 收费记录id
	 */
	@ApiModelProperty(value = "收费记录id")
	private Long id;
	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
	private Long patientId;
	/**
	 * 收费记录创建时间
	 */
	@ApiModelProperty(value = "收费记录创建时间")
	private Date createTime;
	/**
	 * 支付完成时间
	 */
	@ApiModelProperty(value = "支付完成时间")
	private Date paidTime;
	/**
	 * 退款时间
	 */
	@ApiModelProperty(value = "退款时间")
	private Date refundTime;
	/**
	 * 优惠渠道id
	 */
	@ApiModelProperty(value = "优惠渠道id")
	private Integer favorChannelId;
	/**
	 * 优惠渠道名称
	 */
	@ApiModelProperty(value = "优惠渠道名称")
	private String favorChannel;
	/**
	 * 优惠费用
	 */
	@ApiModelProperty(value = "优惠费用")
	private BigDecimal favorFee;
	/**
	 * 支付状态
	 */
	@ApiModelProperty(value = "支付状态")
	private Integer status;
	/**
	 * 支付状态
	 */
	@ApiModelProperty(value = "支付状态")
	private String tollCollectorId;
}

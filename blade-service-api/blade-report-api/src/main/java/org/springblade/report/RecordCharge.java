package org.springblade.report;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("record_charge")
public class RecordCharge {
	/**
	 * 收费记录id
	 */
	@ApiModelProperty(value = "收费记录id")
	private Integer id;
	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
	private Long patientId;

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
	 * 退款时间
	 */
	@ApiModelProperty(value = "退款时间")
	private Date refundTime;

	/**
	 * 支付状态
	 */
	@ApiModelProperty(value = "支付状态")
	private Integer status;

	/**
	 * 收费人员id
	 */
	@ApiModelProperty(value = "收费人员id")
	private Long tollCollectorId;

	/**
	 * 是否上交财务
	 */
	@ApiModelProperty(value = "是否上交财务")
	private Integer turnStatus;

	/**
	 * 费用类别id
	 */
	@ApiModelProperty(value = "费用类别id")
	private Integer categoryId;
}

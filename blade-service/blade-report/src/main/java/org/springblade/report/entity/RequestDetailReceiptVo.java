package org.springblade.report.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class RequestDetailReceiptVo {

	@ApiModelProperty(value = "收费日期:默认不传")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date data;

	@ApiModelProperty(value = "收费员Id")
	private String id;

	@ApiModelProperty(value = "状态位:1全部,2有效,3作废")
	private String status;

	@ApiModelProperty(value = "当前页码")
	private Integer page;

	@ApiModelProperty(value = "每页显示多少条")
	private Integer size;

	@ApiModelProperty(value = "收费类别")
	private String type;

	@ApiModelProperty(value = "医疗证号")
	private String MedicalId;

	@ApiModelProperty(value = "开单医生")
	private String dockerId;

	@ApiModelProperty(value = "发票号码")
	private String invoiceId;

	@ApiModelProperty(value = "住院时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private String hospitalizedDate;

}

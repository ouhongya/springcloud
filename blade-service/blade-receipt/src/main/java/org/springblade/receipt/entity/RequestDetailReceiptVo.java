package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

public class RequestDetailReceiptVo {

	@ApiModelProperty(value = "收费日期:默认不传")
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
	private String hospitalizedDate;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedicalId() {
		return MedicalId;
	}

	public void setMedicalId(String medicalId) {
		MedicalId = medicalId;
	}

	public String getDockerId() {
		return dockerId;
	}

	public void setDockerId(String dockerId) {
		this.dockerId = dockerId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
}

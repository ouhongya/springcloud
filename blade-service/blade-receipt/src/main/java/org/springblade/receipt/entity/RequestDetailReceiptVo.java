package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class RequestDetailReceiptVo {

	@ApiModelProperty(value = "收费日期:默认不传")
	private Date data;

	@ApiModelProperty(value = "收费员:默认不传")
	private String id;

	@ApiModelProperty(value = "状态位:1全部,2有效,3作废")
	private String status;

	@ApiModelProperty(value = "当前页码")
	private Integer page;

	@ApiModelProperty(value = "每页显示多少条")
	private Integer size;

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
}

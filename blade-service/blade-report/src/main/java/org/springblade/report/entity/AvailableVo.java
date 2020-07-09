package org.springblade.report.entity;


import java.util.Date;

public class AvailableVo {

	private String id;

	private String receipt_type;

	private String receipt_number;

	private Integer status;

	private Date createdTime;

	private Date lastUpdateTime;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReceipt_type() {
		return receipt_type;
	}

	public void setReceipt_type(String receipt_type) {
		this.receipt_type = receipt_type;
	}

	public String getReceipt_number() {
		return receipt_number;
	}

	public void setReceipt_number(String receipt_number) {
		this.receipt_number = receipt_number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

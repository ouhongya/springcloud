package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;


public class RefundVo {

	@ApiModelProperty(value = "申请单id")
	private String requestId;

	@ApiModelProperty(value = "项目Id")
	private String itemId;

	@ApiModelProperty(value = "项目名称")
	private String itemName;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}


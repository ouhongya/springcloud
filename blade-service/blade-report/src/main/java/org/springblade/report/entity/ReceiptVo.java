package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;

public class ReceiptVo {
	/**
	 * 旧发票号
	 */
	@ApiModelProperty(value = "旧发票号")
	private String oldReceipt;
	/**
	 * 新发票号
	 */
	@ApiModelProperty(value = "新发票号")
	private String newReceipt;

	public String getOldReceipt() {
		return oldReceipt;
	}

	public void setOldReceipt(String oldReceipt) {
		this.oldReceipt = oldReceipt;
	}

	public String getNewReceipt() {
		return newReceipt;
	}

	public void setNewReceipt(String newReceipt) {
		this.newReceipt = newReceipt;
	}
}

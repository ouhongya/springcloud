package org.springblade.report.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
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

}

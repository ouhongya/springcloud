package org.springblade.receipt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestDetailsReceiptRes {
	@ApiModelProperty(value = "申请单号Id")
	private String requestId;
	@ApiModelProperty(value = "收费项目Id")
	private String itemId;
	@ApiModelProperty(value = "项目类别id")
	private String itemTypeId;
	@ApiModelProperty(value = "数量")
	private String itemCount;
	@ApiModelProperty(value = "发票状态: 0：未启用 1：已启用 2：已开票 3：已退票 4：已作废")
	private String status;
	@ApiModelProperty(value = "总金额")
	private BigDecimal totalMoney;
	@ApiModelProperty(value = "退费金额")
	private BigDecimal refundMoney;
	@ApiModelProperty(value = "支付金额")
	private BigDecimal payMoney;

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
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

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

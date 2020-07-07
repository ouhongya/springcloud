package org.springblade.receipt.entity;

import java.math.BigDecimal;

public class RefundPay {
	private String requestId;
	private BigDecimal feePaid;
	private String channelOrder;
	private String channelAccount;
	private BigDecimal feeFinal;
	private String status;
	private String id;
	private String itemCount;
	private BigDecimal feeItem;

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public BigDecimal getFeeItem() {
		return feeItem;
	}

	public void setFeeItem(BigDecimal feeItem) {
		this.feeItem = feeItem;
	}

	public String getChannelAccount() {
		return channelAccount;
	}

	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount;
	}

	public BigDecimal getFeeFinal() {
		return feeFinal;
	}

	public void setFeeFinal(BigDecimal feeFinal) {
		this.feeFinal = feeFinal;
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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public BigDecimal getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(BigDecimal feePaid) {
		this.feePaid = feePaid;
	}

	public String getChannelOrder() {
		return channelOrder;
	}

	public void setChannelOrder(String channelOrder) {
		this.channelOrder = channelOrder;
	}
}

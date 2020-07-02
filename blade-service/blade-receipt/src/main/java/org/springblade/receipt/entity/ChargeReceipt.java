package org.springblade.receipt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("charge_receipt")
public class ChargeReceipt extends BaseEntity implements Serializable {

	/**
	 * 收费记录id (复合主键1)
	 */
	@ApiModelProperty(value = "收费记录id (复合主键1)")
	private Long chargeId;
	/**
	 * 发票类型 (复合主键2)
	 */
	@ApiModelProperty(value = "发票类型 (复合主键2)")
	private char receiptType;
	/**
	 * 发票号码 (复合主键3)
	 */
	@ApiModelProperty(value = "发票号码 (复合主键3)")
	private String receiptNumber;
	/**
	 * 发票金额
	 */
	@ApiModelProperty(value = "发票金额")
	private BigDecimal fee;

	/**
	 * 发票状态: 0：未启用 1：已启用 2：已开票 3：已退票 4：已作废
	 */
	@ApiModelProperty(value = "发票状态: 0：未启用 1：已启用 2：已开票 3：已退票 4：已作废")
	private Integer status;

	/**
	 * 项目Id集合
	 */
	@ApiModelProperty(value = "项目Id集合")
	private String requestIds;

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public char getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(char receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

	@Override
	public void setStatus(Integer status) {
		this.status = status;
	}
}

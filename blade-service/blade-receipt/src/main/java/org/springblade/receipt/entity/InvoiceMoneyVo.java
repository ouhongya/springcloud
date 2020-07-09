package org.springblade.receipt.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceMoneyVo {

	private BigDecimal cash;

	private BigDecimal wxPay;

	private BigDecimal aliPay;
}

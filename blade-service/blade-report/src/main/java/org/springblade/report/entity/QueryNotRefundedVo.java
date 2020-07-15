package org.springblade.report.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QueryNotRefundedVo {
	private String requestId;
	private String itemTypeId;
	private BigDecimal feeItem;
	private String itemCount;
	private BigDecimal feeFinal;
}

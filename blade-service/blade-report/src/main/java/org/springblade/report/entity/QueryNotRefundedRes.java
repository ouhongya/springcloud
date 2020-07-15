package org.springblade.report.entity;

import lombok.Data;

import java.util.List;

@Data
public class QueryNotRefundedRes {
	private List<ReceiptVo> receiptVo;
	private List<List<QueryNotRefundedVo>> notRefund;
}

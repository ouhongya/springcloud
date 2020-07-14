package org.springblade.report.entity;

import lombok.Data;

import java.util.List;

@Data
public class RequestDetailReceiptRes {
	private List<ReceiptVo> receiptVo;
	private List<List<RequestDetailsVo>> requestDetailsVo;
}

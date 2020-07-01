package org.springblade.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptList;

import java.util.List;

public interface ReceiptMapper extends BaseMapper<ChargeReceipt> {

	List<ReceiptList> queryReceipt(String receiptId, String requestId);

	String queryReceiptRequestDetail(String receiptId);

	void updateReceiptStatus(String requestId);

	void createdReceipt(ChargeReceipt createdReceipt);
}

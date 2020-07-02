package org.springblade.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptList;
import org.springblade.receipt.entity.RefundProject;

import java.util.List;

public interface ReceiptMapper extends BaseMapper<ChargeReceipt> {

	List<ReceiptList> queryReceipt(String receiptId, String requestId);

	String queryReceiptById(String id);

	String queryReceiptRequestDetail(String receiptId);

	void updateReceiptStatus(String requestId);

	void createdReceipt(ChargeReceipt createdReceipt);

	ChargeReceipt queryReceiptByIds(String id);

 	RefundProject queryRefundProject(String requestId);

	void updatePayStatus(String requestId,Integer status,String reason);
}

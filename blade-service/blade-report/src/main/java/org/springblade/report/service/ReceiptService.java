package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.entity.*;

import java.util.List;

public interface ReceiptService extends IService<ChargeReceipt> {

	List<ReceiptList> receiptList(String receiptId, String requestId);

	List<ReceiptVo> queryRequestDetailReceipt(List<String> requestIds);

	boolean printInvoice(List<ReceiptVo> receiptVo,String username);

	String refund(List<RefundVo> refundVo, String userName, String reason);

	InvoiceMoneyVo invoiceMoney(List<String> requestIds);
}

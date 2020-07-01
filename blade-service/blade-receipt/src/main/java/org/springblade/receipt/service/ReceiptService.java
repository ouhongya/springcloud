package org.springblade.receipt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptList;

import java.util.List;

public interface ReceiptService extends IService<ChargeReceipt> {

	List<ReceiptList> receiptList(String receiptId,String requestId);

	boolean printInvoice(String requestId,String receiptId,String username);

	String refund(String requestId,String userName,String reason);
}

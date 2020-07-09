package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ReceiptMapper extends BaseMapper<ChargeReceipt> {

	List<ReceiptList> queryReceipt(String receiptId, String requestId);

	String queryReceiptById(String id);

	String queryReceiptByIdNew();

	void queryReceiptByIdNewStatus(String num);

	String queryReceiptRequestDetail(String receiptId);

	void updateReceiptStatus(String requestId);

	void createdReceipt(ChargeReceipt createdReceipt);

	ChargeReceipt queryReceiptByIds(String id);

 	RefundProject queryRefundProject(String requestId);

	DecimalMoney queryRefundMoey(String requestId);

	RefundPay queryRefundPay(String requestId, String itemId);

	void updatePayStatus(String requestId, Date date, Integer status, String userName, String reason);

	InvoiceMoneyVo queryInvoiceMoney(String id);

	void updateChargePay(String requestId, Date date,BigDecimal money, Integer status, String userName, String reason);
}

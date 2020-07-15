package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.report.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ReceiptMapper extends BaseMapper<ChargeReceipt> {

	List<ReceiptList> queryReceipt(@Param("receiptId") String receiptId,@Param("requestId") String requestId);

	String queryReceiptById(String id);

	List<QueryNotRefundedVo> queryNotRefunded(String id);

	String queryReceiptNum(String id);

	List<RequestDetailsVo> queryRequestDetails(String id);

	List<String> queryReceiptByIdNew(@Param("size") int size);

	void queryReceiptByIdNewStatus(String num);

	String queryReceiptRequestDetail(String receiptId);

	void updateReceiptStatus(String requestId);

	void createdReceipt(ChargeReceipt createdReceipt);

	ChargeReceipt queryReceiptByIds(String id);

	void updateStatue();

 	RefundProject queryRefundProject(String requestId);

	DecimalMoney queryRefundMoey(String requestId);

	RefundPay queryRefundPay(@Param("requestId")String requestId,@Param("itemId") String itemId);

	void updatePayStatus(@Param("requestId") String requestId,@Param("date") Date date,@Param("status") Integer status,@Param("userName") String userName,@Param("reason") String reason);

	List<Integer> queryInvoiceMoney(String requestId);

	void updateChargePay(@Param("requestId")String requestId,@Param("date") Date date,@Param("money") BigDecimal money,@Param("status")Integer status, @Param("userName")String userName, @Param("reason")String reason);
}

package org.springblade.receipt.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptList;
import org.springblade.receipt.entity.RefundProject;
import org.springblade.receipt.fegin.ChargePayClient;
import org.springblade.receipt.mapper.ReceiptMapper;
import org.springblade.receipt.service.ReceiptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现类
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class ReceiptServiceImpl extends BaseServiceImpl<ReceiptMapper, ChargeReceipt> implements ReceiptService{

	private ReceiptMapper receiptMapper;

	private ChargePayClient chargePayClient;
	/**
	 * 查询发票列表
	 * @param receiptId
	 * @param requestId
	 * @return
	 */
	@Override
	public List<ReceiptList> receiptList(String receiptId, String requestId) {
		return receiptMapper.queryReceipt(receiptId,requestId);
	}

	/**
	 * 打印发票
	 * @param requestId 旧发票
	 * @param receiptId 新发票
	 * @param username 操作人名
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean printInvoice(String requestId, String receiptId, String username) {
		//拉取用户信息
		//先把之前的发票置为已作废
		receiptMapper.updateReceiptStatus(requestId);
		//发票代码和号码、联次及用途、客户名称、开户银行及账号、商品名称或经营项目、计量单位、数量、单价、大小写金额、开票人、开票日期、开票单位(个人)名称(章)
		String s = receiptMapper.queryReceiptRequestDetail(receiptId);
		//创建一张新的发票为已使用
		ChargeReceipt chargeReceipt = new ChargeReceipt();
		receiptMapper.createdReceipt(chargeReceipt);
		return true;
	}

	/**
	 * 退款操作
	 * @param requestId 申请单号
	 * @param userName 操作人
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String refund(String requestId, String userName) {
		//查询支付记录&判断状态
		RefundProject refundProject = receiptMapper.queryRefundProject(requestId);
		//远程调用进行退款
		chargePayClient.refundService();
		//退款成功改状态
		receiptMapper.updatePayStatus(requestId,5);
		return "退款成功";
	}

}

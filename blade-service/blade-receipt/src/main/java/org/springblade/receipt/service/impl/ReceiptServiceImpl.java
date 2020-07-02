package org.springblade.receipt.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.common.utils.CommonUtil;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptList;
import org.springblade.receipt.entity.ReceiptVo;
import org.springblade.receipt.entity.RefundProject;
import org.springblade.receipt.fegin.ChargePayClient;
import org.springblade.receipt.mapper.ReceiptMapper;
import org.springblade.receipt.service.ReceiptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class ReceiptServiceImpl extends BaseServiceImpl<ReceiptMapper, ChargeReceipt> implements ReceiptService {


	private ChargePayClient chargePayClient;

	/**
	 * 发票列表
	 *
	 * @param receiptId
	 * @param requestId
	 * @return
	 */
	@Override
	public List<ReceiptList> receiptList(String receiptId, String requestId) {
		return baseMapper.queryReceipt(receiptId, requestId);
	}

	/**
	 * 发票号列表
	 *
	 * @param requestIds
	 * @return
	 */
	@Override
	public List<ReceiptVo> queryRequestDetailReceipt(List<String> requestIds) {
		//查询当前的发票号
		List<ReceiptVo> receipt = new ArrayList<ReceiptVo>();
		ReceiptVo receiptVo = new ReceiptVo();
		for (String id : requestIds) {
			receiptVo.setOldReceipt(baseMapper.queryReceiptById(id));
			receiptVo.setNewReceipt("暂无");
			receipt.add(receiptVo);
		}
		return receipt;
	}

	/**
	 * 打印发票
	 *
	 * @param receiptVo 发票列表
	 * @param username  操作人名
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean printInvoice(List<ReceiptVo> receiptVo, String username) {
		for (ReceiptVo receipt : receiptVo) {
			//先把之前的发票置为已作废
			baseMapper.updateReceiptStatus(receipt.getOldReceipt());
			ChargeReceipt chargeReceipt = baseMapper.queryReceiptByIds(receipt.getOldReceipt());
			//创建一张新的发票
			String millis = System.currentTimeMillis()+"";
			String substring = millis.substring(5, millis.length());
			chargeReceipt.setId(Long.valueOf(substring));
			chargeReceipt.setReceiptNumber(receipt.getNewReceipt());
			chargeReceipt.setStatus(2);
			baseMapper.createdReceipt(chargeReceipt);
		}
		//发票代码和号码、联次及用途、客户名称、开户银行及账号、商品名称或经营项目、计量单位、数量、单价、大小写金额、开票人、开票日期、开票单位(个人)名称(章)
		//调用打印设备打印
		return true;
	}

	/**
	 * 退款操作
	 *
	 * @param requestId 申请单号
	 * @param userName  操作人
	 * @param reason    退费理由
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String refund(String requestId, String userName, String reason) {
		//查询支付记录&判断状态
		RefundProject refundProject = baseMapper.queryRefundProject(requestId);
		//远程调用进行退款
		chargePayClient.refundService();
		//退款成功改状态
		baseMapper.updatePayStatus(requestId, 5, reason);
		return "退款成功";
	}
}

package org.springblade.report.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.*;
import org.springblade.report.mapper.ChargeDetailsMapper;
import org.springblade.report.service.ChargeDetailsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChargeDetailsServiceImpl extends BaseServiceImpl<ChargeDetailsMapper, ChargeReceipt> implements ChargeDetailsService {

	/**
	 * 费用明细查询
	 * @param requestDetailReceiptVo
	 * @return
	 */
	@Override
	public PageInfo queryChargeDetailsList(RequestDetailReceiptVo requestDetailReceiptVo) {
		PageHelper.startPage(requestDetailReceiptVo.getPage(),requestDetailReceiptVo.getSize());
		List<RequestDetailsReceiptRes> receiptResList= baseMapper.queryRequestDetailReceipt(requestDetailReceiptVo);
		//总金额
		BigDecimal totalMoney = new BigDecimal("0.00");
		//退费金额
		BigDecimal refundMoney = new BigDecimal("0.00");
		//支付金额
		BigDecimal payMoney = new BigDecimal("0.00");
		for (RequestDetailsReceiptRes detailsReceiptRes : receiptResList) {
			BigDecimal multiply = detailsReceiptRes.getFeeItem().multiply(new BigDecimal(detailsReceiptRes.getItemCount()));
			detailsReceiptRes.setFeeItem(multiply);
			totalMoney.add(detailsReceiptRes.getFeeItem().subtract(detailsReceiptRes.getFeeFavor()));
			refundMoney.add(detailsReceiptRes.getRefundMoney());
			payMoney.add(detailsReceiptRes.getFeeFinal().subtract(detailsReceiptRes.getRefundMoney()));
		}
		receiptResList.get(0).setTotalMoney(totalMoney);
		receiptResList.get(0).setRefundMoney(refundMoney);
		receiptResList.get(0).setPayMoney(payMoney);
		return new PageInfo<>(receiptResList);
	}

	/**
	 * 住院预交金
	 * @param requestDetailReceiptVo
	 * @return
	 */
	@Override
	public PageInfo queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo) {
		PageHelper.startPage(requestDetailReceiptVo.getPage(),requestDetailReceiptVo.getSize());
		List<HospitalizedVo> receiptResList= baseMapper.queryHospitalizedList(requestDetailReceiptVo);
		return new PageInfo<>(receiptResList);
	}

	/**
	 * 发票列表
	 * @param requestDetailReceiptVo
	 * @return
	 */
	@Override
	public PageInfo queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo) {
		PageHelper.startPage(requestDetailReceiptVo.getPage(),requestDetailReceiptVo.getSize());
		List<InvoiceVo> receiptResList= baseMapper.queryInvoiceList(requestDetailReceiptVo);
		BigDecimal refundMoney = new BigDecimal("0.00");
		BigDecimal totalAccoutMoney = new BigDecimal("0.00");
		BigDecimal payAccoutMoney = new BigDecimal("0.00");
		for (InvoiceVo invoiceVo : receiptResList) {
			refundMoney=refundMoney.add(invoiceVo.getRefundMoney());
			totalAccoutMoney=totalAccoutMoney.add(invoiceVo.getTotalMoney());
			payAccoutMoney=payAccoutMoney.add(invoiceVo.getPayMoney());
		}
		receiptResList.get(0).setRefundAccoutMoney(refundMoney);
		receiptResList.get(0).setTotalAccoutMoney(totalAccoutMoney);
		receiptResList.get(0).setPayAccoutMoney(payAccoutMoney);
		return new PageInfo<>(receiptResList);
	}
}

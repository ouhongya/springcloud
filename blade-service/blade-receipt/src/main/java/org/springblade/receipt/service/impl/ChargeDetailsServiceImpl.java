package org.springblade.receipt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.receipt.entity.*;
import org.springblade.receipt.mapper.ChargeDetailsMapper;
import org.springblade.receipt.service.ChargeDetailsService;
import org.springframework.stereotype.Service;

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
		return new PageInfo<>(receiptResList);
	}
}

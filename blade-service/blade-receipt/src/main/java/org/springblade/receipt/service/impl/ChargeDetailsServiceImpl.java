package org.springblade.receipt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.RequestDetailReceiptVo;
import org.springblade.receipt.entity.RequestDetailsReceiptRes;
import org.springblade.receipt.mapper.ChargeDetailsMapper;
import org.springblade.receipt.mapper.ReceiptMapper;
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
	public PageInfo queryRequestDetailReceipt(RequestDetailReceiptVo requestDetailReceiptVo) {
		PageHelper.startPage(requestDetailReceiptVo.getPage(),requestDetailReceiptVo.getSize());
		List<RequestDetailsReceiptRes> receiptResList= baseMapper.queryRequestDetailReceipt(requestDetailReceiptVo);
		return new PageInfo<>(receiptResList);
	}
}

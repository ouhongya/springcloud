package org.springblade.report.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.entity.FeeRequest;
import org.springblade.report.mapper.CallBackReceiptMapper;
import org.springblade.report.service.CallBackReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class CallBackReceiptServiceImpl extends BaseServiceImpl<CallBackReceiptMapper, FeeRequest> implements CallBackReceiptService {

	/**
	 * 接受推送的发票数据
	 * @param availableVo
	 * @return
	 */
	@Override
	public boolean createdAvailable(List<AvailableVo> availableVo) {
		for (AvailableVo vo : availableVo) {
			vo.setId(UUID.randomUUID().toString().replace("-",""));
			baseMapper.createdAvailable(vo);
		}
		baseMapper.updateAvailable();
		return true;
	}
}

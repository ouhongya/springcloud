package org.springblade.sysettings.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.dictionary.DictChargeStatus;
import org.springblade.sysettings.mapper.ChargeStatusMapper;
import org.springblade.sysettings.service.IChargeStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:57
 */

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChargeStatusServiceImpl extends BaseServiceImpl<ChargeStatusMapper, DictChargeStatus> implements IChargeStatusService {
	private ChargeStatusMapper chargeStatusMapper;

	@Override
	public List<DictChargeStatus> selectAll() {
		return  chargeStatusMapper.selectAll();
	}

	@Override
	public DictChargeStatus selectById(Long id) {
		return chargeStatusMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delById(Long id) {
		return chargeStatusMapper.delById(id);
	}

	@Override
	public DictChargeStatus updateByIds(DictChargeStatus dictChargeStatus) {
		return chargeStatusMapper.updateByIds(dictChargeStatus);
	}

	@Override
	public int insert(DictChargeStatus dictChargeStatus) {
		return chargeStatusMapper.add(dictChargeStatus);
	}


}

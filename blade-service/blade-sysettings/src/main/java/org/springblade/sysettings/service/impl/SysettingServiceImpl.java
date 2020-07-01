package org.springblade.sysettings.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.dictchargestatus.DictChargeStatus;
import org.springblade.sysettings.mapper.SysettingMapper;
import org.springblade.sysettings.service.ISysettingService;
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
public class SysettingServiceImpl extends BaseServiceImpl<SysettingMapper, DictChargeStatus> implements ISysettingService {
	private SysettingMapper sysettingMapper;

	@Override
	public List<DictChargeStatus> selectAll() {
		return  sysettingMapper.selectAll();
	}

	@Override
	public DictChargeStatus selectById(Long id) {
		return sysettingMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delById(Long id) {
		return sysettingMapper.delById(id);
	}

	@Override
	public DictChargeStatus updateByIds(DictChargeStatus dictChargeStatus) {
		return sysettingMapper.updateByIds(dictChargeStatus);
	}

	@Override
	public int insert(DictChargeStatus dictChargeStatus) {
		return sysettingMapper.add(dictChargeStatus);
	}


}

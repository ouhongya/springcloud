package org.springblade.sysettings.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.dictionary.DictChannelType;
import org.springblade.sysettings.mapper.DictChannelTypeMapper;
import org.springblade.sysettings.service.IChannelTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-16:24
 */
/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChannelTypeServiceImpl extends BaseServiceImpl<DictChannelTypeMapper, DictChannelType> implements IChannelTypeService {
	private DictChannelTypeMapper channelTypeMapper;

	@Override
	public List<DictChannelType> selectAll() {
		return  channelTypeMapper.selectAll();
	}

	@Override
	public DictChannelType selectById(Integer id) {
		return channelTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delById(Integer id) {
		return channelTypeMapper.delById(id);
	}

	@Override
	public int updateByIds(DictChannelType dictChannelType) {
		return channelTypeMapper.updateByIds(dictChannelType);
	}

	@Override
	public int insert(DictChannelType dictChannelType) {
		return channelTypeMapper.add(dictChannelType);
	}

}

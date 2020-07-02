package org.springblade.sysettings.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.dictionary.DictChannelType;
import org.springblade.dictionary.DictRequestType;
import org.springblade.sysettings.mapper.DictChannelTypeMapper;
import org.springblade.sysettings.mapper.RequestTypeMapper;
import org.springblade.sysettings.service.IChannelTypeService;
import org.springblade.sysettings.service.IRequestTypeService;
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
public class RequestTypeServiceImpl extends BaseServiceImpl<RequestTypeMapper, DictRequestType> implements IRequestTypeService {
	private RequestTypeMapper requestTypeMapper;

	@Override
	public List<DictRequestType> selectAll() {
		return requestTypeMapper.selectAll();
	}

	@Override
	public DictRequestType selectById(Integer id) {
		return requestTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delById(Integer id) {
		return requestTypeMapper.delById(id);
	}

	@Override
	public int updateByIds(DictRequestType dictRequestType) {
		return requestTypeMapper.updateByIds(dictRequestType);
	}

	@Override
	public int insert(DictRequestType dictRequestType) {
		return requestTypeMapper.add(dictRequestType);
	}

}

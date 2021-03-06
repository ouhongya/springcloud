package org.springblade.report.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.dictionary.DictChannelType;
import org.springblade.report.entity.report.ReportRecords;
import org.springblade.report.mapper.dictionary.DictChannelTypeMapper;
import org.springblade.report.service.IChannelTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-16:24
 */

/**
 * 服务实现类
 *
 * @author
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChannelTypeServiceImpl extends BaseServiceImpl<DictChannelTypeMapper, DictChannelType> implements IChannelTypeService {
	private DictChannelTypeMapper channelTypeMapper;

	@Override
	public List<DictChannelType> selectAll() {
		return channelTypeMapper.selectAll();
	}

	@Override
	public DictChannelType selectById(Integer id) {
		return channelTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public String updateByIds(List<Integer> ids) {
		channelTypeMapper.updateByIds1();
		for (Integer id : ids) {
			channelTypeMapper.updateByIds(id);
		}
		return "操作成功";
	}

	@Override
	public int insert(DictChannelType dictChannelType) {
		return channelTypeMapper.add(dictChannelType);
	}

}

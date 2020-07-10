package org.springblade.report.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.dictionary.DictRequestType;
import org.springblade.report.mapper.dictionary.RequestTypeMapper;
import org.springblade.report.service.IRequestTypeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	public String updateByIds(@RequestBody List<Integer> ids) {
		requestTypeMapper.updateByIds1();
		for (Integer id : ids) {
			requestTypeMapper.updateByIds(id);
		}
		return "操作成功";
	}

		@Override
		public int insert (DictRequestType dictRequestType){
			return requestTypeMapper.add(dictRequestType);
		}

	}

package org.springblade.report.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.dictionary.ExpiryDate;
import org.springblade.report.mapper.dictionary.ExpiryDateMapper;
import org.springblade.report.service.IExpiryDateService;
import org.springframework.stereotype.Service;

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
public class ExpiryDateServiceImpl extends BaseServiceImpl<ExpiryDateMapper, ExpiryDate> implements IExpiryDateService {
	private ExpiryDateMapper expiryDateMapper;

	@Override
	public List<ExpiryDate> selectAll() {
		return expiryDateMapper.selectAll();
	}

	@Override
	public ExpiryDate selectById(Integer id) {
		return expiryDateMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByIds(Integer validQuantum) {
		return expiryDateMapper.updateByIds(validQuantum);
	}

	@Override
	public int insert(ExpiryDate expiryDate) {
		return expiryDateMapper.add(expiryDate);
	}

}

package org.springblade.sysettings.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.dictionary.ExpiryDate;
import org.springblade.sysettings.mapper.ExpiryDateMapper;
import org.springblade.sysettings.service.IExpiryDateService;
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
	public int updateByIds(ExpiryDate expiryDate) {
		return expiryDateMapper.updateByIds(expiryDate);
	}

	@Override
	public int insert(ExpiryDate expiryDate) {
		return expiryDateMapper.add(expiryDate);
	}

}
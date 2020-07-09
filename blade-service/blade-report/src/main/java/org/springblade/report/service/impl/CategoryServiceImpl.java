package org.springblade.report.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.report.entity.dictionary.Category;
import org.springblade.report.mapper.dictionary.CategoryMapper;
import org.springblade.report.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author create by
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
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements ICategoryService {
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> selectAll() {
		return  categoryMapper.selectAll();
	}

	@Override
	public Category selectById(Long categoryId) {
		return categoryMapper.selectByPrimaryKey(categoryId);
	}


	@Override
	public int insert(Category category) {
		return categoryMapper.add(category);
	}


}

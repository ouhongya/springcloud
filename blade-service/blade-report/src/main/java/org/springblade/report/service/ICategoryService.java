package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictionary.Category;
import org.springblade.dictionary.DictChargeStatus;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-10:56
 */
public interface ICategoryService extends IService<Category> {
	List<Category> selectAll();

	Category selectById(Long categoryId);

	int insert(Category category);
}

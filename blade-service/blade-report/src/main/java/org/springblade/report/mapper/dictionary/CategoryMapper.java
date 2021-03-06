package org.springblade.report.mapper.dictionary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.dictionary.Category;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-11:25
 */
public interface CategoryMapper extends BaseMapper<Category> {
	Category selectByPrimaryKey(Long id);


	List<Category> selectAll();

	int add(Category category);
}

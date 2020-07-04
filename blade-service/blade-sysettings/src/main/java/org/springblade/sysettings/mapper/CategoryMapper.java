package org.springblade.sysettings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.dictionary.Category;
import org.springblade.dictionary.DictChargeStatus;

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
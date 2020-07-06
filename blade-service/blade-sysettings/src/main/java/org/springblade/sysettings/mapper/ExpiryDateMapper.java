package org.springblade.sysettings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.dictionary.ExpiryDate;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-16:27
 */
public interface ExpiryDateMapper extends BaseMapper<ExpiryDate> {
	ExpiryDate selectByPrimaryKey(Integer id);


	List<ExpiryDate> selectAll();

	int updateByIds(ExpiryDate expiryDate);

	int add(ExpiryDate expiryDate);
}

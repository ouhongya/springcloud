package org.springblade.report.mapper.dictionary;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.dictionary.DictRequestType;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-16:27
 */
public interface RequestTypeMapper extends BaseMapper<DictRequestType> {
	DictRequestType selectByPrimaryKey(Integer id);


	List<DictRequestType> selectAll();

	int updateByIds(Integer id);

	void updateByIds1();

	int add(DictRequestType dictRequestType);
}

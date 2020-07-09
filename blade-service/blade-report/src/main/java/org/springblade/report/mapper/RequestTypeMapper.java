package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.dictionary.DictRequestType;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-16:27
 */
public interface RequestTypeMapper extends BaseMapper<DictRequestType> {
	DictRequestType selectByPrimaryKey(Integer id);


	List<DictRequestType> selectAll();

	int updateByIds(DictRequestType dictRequestType);

	int add(DictRequestType dictRequestType);
}

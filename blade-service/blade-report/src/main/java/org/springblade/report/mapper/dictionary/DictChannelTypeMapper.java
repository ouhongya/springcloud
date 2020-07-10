package org.springblade.report.mapper.dictionary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.dictionary.DictChannelType;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-16:27
 */
public interface DictChannelTypeMapper extends BaseMapper<DictChannelType> {
	DictChannelType selectByPrimaryKey(Integer id);


	List<DictChannelType> selectAll();

	int updateByIds(Integer id);

	void updateByIds1();

	int add(DictChannelType dictChannelType);
}

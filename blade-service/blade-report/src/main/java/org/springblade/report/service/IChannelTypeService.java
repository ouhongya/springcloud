package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.dictionary.DictChannelType;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-10:56
 */
public interface IChannelTypeService extends IService<DictChannelType> {
	List<DictChannelType> selectAll();

	DictChannelType selectById(Integer id);

	int updateByIds(DictChannelType dictChannelType);

	int insert(DictChannelType dictChannelType);
}

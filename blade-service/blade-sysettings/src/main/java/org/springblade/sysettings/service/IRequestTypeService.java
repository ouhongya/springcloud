package org.springblade.sysettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictionary.DictChannelType;
import org.springblade.dictionary.DictRequestType;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:56
 */
public interface IRequestTypeService extends IService<DictRequestType> {
	List<DictRequestType> selectAll();

	DictRequestType selectById(Integer id);

	int delById(Integer id);

	int updateByIds(DictRequestType dictRequestType);

	int insert(DictRequestType dictRequestType);
}
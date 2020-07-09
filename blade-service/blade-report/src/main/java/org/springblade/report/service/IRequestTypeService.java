package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.dictionary.DictRequestType;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:56
 */
public interface IRequestTypeService extends IService<DictRequestType> {
	List<DictRequestType> selectAll();

	DictRequestType selectById(Integer id);

	int updateByIds(DictRequestType dictRequestType);

	int insert(DictRequestType dictRequestType);
}

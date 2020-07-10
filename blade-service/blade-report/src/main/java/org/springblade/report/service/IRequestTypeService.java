package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.entity.dictionary.DictRequestType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:56
 */
public interface IRequestTypeService extends IService<DictRequestType> {
	List<DictRequestType> selectAll();

	DictRequestType selectById(Integer id);

	String updateByIds(List<Integer> ids);

	int insert(DictRequestType dictRequestType);
}

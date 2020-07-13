package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.entity.dictionary.ExpiryDateVo;

import java.util.List;


/**
 * @Author create by
 * @date 2020/7/1-10:56
 */
public interface IExpiryDateService extends IService<ExpiryDateVo> {
	List<ExpiryDateVo> selectAll();

	ExpiryDateVo selectById(Integer id);

	int updateByIds(Integer validQuantum);

	int insert(ExpiryDateVo expiryDateVo);
}

package org.springblade.sysettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictionary.DictChannelType;
import org.springblade.dictionary.ExpiryDate;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-10:56
 */
public interface IExpiryDateService extends IService<ExpiryDate> {
	List<ExpiryDate> selectAll();

	ExpiryDate selectById(Integer id);

	int updateByIds(ExpiryDate expiryDate);

	int insert(ExpiryDate expiryDate);
}
package org.springblade.sysettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictionary.DictChargeStatus;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:56
 */
public interface IChargeStatusService extends IService<DictChargeStatus> {
	List<DictChargeStatus> selectAll();

	DictChargeStatus selectById(Long id);

	int delById(Long id);

	int updateByIds(DictChargeStatus dictChargeStatus);

	int insert(DictChargeStatus dictChargeStatus);
}

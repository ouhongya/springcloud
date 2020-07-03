package org.springblade.sysettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictionary.DictChargeStatus;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-10:56
 */
public interface IChargeStatusService extends IService<DictChargeStatus> {
	List<DictChargeStatus> selectAll();

	DictChargeStatus selectById(Long id);

	int insert(DictChargeStatus dictChargeStatus);
}

package org.springblade.sysettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.dictchargestatus.DictChargeStatus;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-10:56
 */
public interface ISysettingService extends IService<DictChargeStatus> {
	List<DictChargeStatus> selectAll();

	DictChargeStatus selectById(Long id);

	int delById(Long id);

	DictChargeStatus updateByIds(DictChargeStatus dictChargeStatus);

	int insert(DictChargeStatus dictChargeStatus);
}

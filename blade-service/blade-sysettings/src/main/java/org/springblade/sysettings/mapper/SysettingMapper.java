package org.springblade.sysettings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.dictchargestatus.DictChargeStatus;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-11:25
 */
public interface SysettingMapper extends BaseMapper<DictChargeStatus> {
	DictChargeStatus selectByPrimaryKey(Long id);


	List<DictChargeStatus> selectAll();

	int delById(Long id);

	DictChargeStatus updateByIds(DictChargeStatus dictChargeStatus);

	int add(DictChargeStatus dictChargeStatus);
}

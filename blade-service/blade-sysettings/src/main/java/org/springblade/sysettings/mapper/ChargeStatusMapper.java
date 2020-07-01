package org.springblade.sysettings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.dictionary.DictChargeStatus;

import java.util.List;

/**
 * @Author create by yaodan
 * @date 2020/7/1-11:25
 */
public interface ChargeStatusMapper extends BaseMapper<DictChargeStatus> {
	DictChargeStatus selectByPrimaryKey(Long id);


	List<DictChargeStatus> selectAll();

	int delById(Long id);

	int updateByIds(DictChargeStatus dictChargeStatus);

	int add(DictChargeStatus dictChargeStatus);
}

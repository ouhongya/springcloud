package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.dictionary.DictChargeStatus;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-11:25
 */
public interface ChargeStatusMapper extends BaseMapper<DictChargeStatus> {
	DictChargeStatus selectByPrimaryKey(Long id);


	List<DictChargeStatus> selectAll();

	int add(DictChargeStatus dictChargeStatus);
}

package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.entity.Fee;

public interface CallBackMapper extends BaseMapper<Fee> {

	void createdAvailable(AvailableVo availableVo);

	void updateAvailable();
}

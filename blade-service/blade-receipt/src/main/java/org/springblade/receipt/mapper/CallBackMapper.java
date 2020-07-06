package org.springblade.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.receipt.entity.AvailableVo;
import org.springblade.receipt.entity.Fee;

public interface CallBackMapper extends BaseMapper<Fee> {

	void createdAvailable(AvailableVo availableVo);

	void updateAvailable();
}

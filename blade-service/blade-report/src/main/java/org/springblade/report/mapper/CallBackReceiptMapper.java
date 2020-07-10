package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.entity.FeeRequest;

public interface CallBackReceiptMapper extends BaseMapper<FeeRequest> {

	void createdAvailable(AvailableVo availableVo);

	void updateAvailable();
}

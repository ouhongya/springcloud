package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.entity.Fee;

import java.util.List;

public interface CallBackService extends IService<Fee> {
	boolean createdAvailable(List<AvailableVo> availableVo);
}

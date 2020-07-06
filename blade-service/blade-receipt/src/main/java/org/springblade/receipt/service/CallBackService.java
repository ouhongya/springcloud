package org.springblade.receipt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.receipt.entity.AvailableVo;
import org.springblade.receipt.entity.Fee;

import java.util.List;

public interface CallBackService extends IService<Fee> {
	boolean createdAvailable(List<AvailableVo> availableVo);
}

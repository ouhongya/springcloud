package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.entity.FeeRequest;

import java.util.List;

public interface CallBackReceiptService extends IService<FeeRequest> {
	boolean createdAvailable(List<AvailableVo> availableVo);
}

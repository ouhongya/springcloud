package org.springblade.receipt.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.receipt.entity.AvailableVo;
import org.springblade.receipt.entity.Fee;
import org.springblade.receipt.mapper.CallBackMapper;
import org.springblade.receipt.service.CallBackService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

/**
 * 服务实现类
 *
 * @author Chill
 */
@Slf4j
@Service
@AllArgsConstructor
public class CallBackServiceImpl extends BaseServiceImpl<CallBackMapper, Fee> implements CallBackService {

	/**
	 * 接受推送的发票数据
	 * @param availableVo
	 * @return
	 */
	@Override
	public boolean createdAvailable(List<AvailableVo> availableVo) {
		for (AvailableVo vo : availableVo) {
			vo.setId(UUID.randomUUID().toString().replace("-",""));
			baseMapper.createdAvailable(vo);
		}
		baseMapper.updateAvailable();
		return true;
	}
}

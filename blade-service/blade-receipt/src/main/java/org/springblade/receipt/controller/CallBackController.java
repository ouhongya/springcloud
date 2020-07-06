package org.springblade.receipt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.receipt.entity.AvailableVo;
import org.springblade.receipt.service.CallBackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "回调", tags = "回调")
@RestController
@AllArgsConstructor
public class CallBackController {

	private CallBackService callBackService;

	@GetMapping("/receipt/get-available")
	@ApiOperation(value = "发票回调", notes = "发票回调")
	public R getAvailable(List<AvailableVo> availableVo) {
		return R.data(callBackService.createdAvailable(availableVo));
	}
}

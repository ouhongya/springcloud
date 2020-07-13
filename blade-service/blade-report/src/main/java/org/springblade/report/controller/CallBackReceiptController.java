package org.springblade.report.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.AvailableVo;
import org.springblade.report.service.CallBackReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "回调", tags = "回调")
@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class CallBackReceiptController {

	private CallBackReceiptService callBackService;

	@GetMapping("/receipt/get-available")
	@ApiOperation(value = "发票回调", notes = "发票回调")
	public R getAvailable(List<AvailableVo> availableVo) {
		return R.data(callBackService.createdAvailable(availableVo));
	}
}

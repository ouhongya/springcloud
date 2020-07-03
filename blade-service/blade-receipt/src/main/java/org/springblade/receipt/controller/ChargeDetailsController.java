package org.springblade.receipt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.receipt.entity.RequestDetailReceiptVo;
import org.springblade.receipt.service.ChargeDetailsService;
import org.springframework.web.bind.annotation.*;

@Api(value = "费用明细", tags = "费用明细")
@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ChargeDetailsController {

	private ChargeDetailsService chargeDetailsService;

	@GetMapping("/queryChargeDetailsList")
	@ApiOperation(value = "费用明细查询", notes = "费用明细查询")
	public R queryRequestDetailReceipt(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryRequestDetailReceipt(requestDetailReceiptVo));
	};
}

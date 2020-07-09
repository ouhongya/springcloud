package org.springblade.report.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.RequestDetailReceiptVo;
import org.springblade.report.service.ChargeDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "费用明细", tags = "费用明细")
@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ChargeDetailsController {

	private ChargeDetailsService chargeDetailsService;

	@GetMapping("/queryChargeDetailsList")
	@ApiOperation(value = "费用明细查询", notes = "费用明细查询")
	public R queryChargeDetailsList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryChargeDetailsList(requestDetailReceiptVo));
	}

	@GetMapping("/queryHospitalizedList")
	@ApiOperation(value = "住院预交金查询", notes = "住院预交金查询")
	public R queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryHospitalizedList(requestDetailReceiptVo));
	}

	@GetMapping("/queryInvoiceList")
	@ApiOperation(value = "发票列表", notes = "发票列表")
	public R queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryInvoiceList(requestDetailReceiptVo));
	}
}

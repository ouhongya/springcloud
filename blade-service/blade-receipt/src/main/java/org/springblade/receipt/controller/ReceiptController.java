package org.springblade.receipt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.common.utils.CommonUtil;
import org.springblade.core.tool.api.R;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 发票业务
 */
@Api(value = "发票接口", tags = "发票接口")
@RequestMapping("api")
@RestController
@AllArgsConstructor
public class ReceiptController {

	private ReceiptService receiptService;

	@PostMapping("/createdReceipt")
	@ApiOperation(value = "创建发票", notes = "创建发票")
	public R createdReceipt(@RequestBody ChargeReceipt chargeReceipt) {
		chargeReceipt.setChargeId(Long.parseLong(""));
		return R.status(receiptService.save(chargeReceipt));
	}

	@GetMapping("/updateReceipt")
	@ApiOperation(value = "修改发票", notes = "修改发票")
	public R updateReceipt(Long id,Integer status) {
		ChargeReceipt chargeReceipt = new ChargeReceipt();
		chargeReceipt.setId(id);
		chargeReceipt.setStatus(status);
		return R.status(receiptService.updateById(chargeReceipt));
	}

	@GetMapping("/queryReceipt")
	@ApiOperation(value = "发票列表", notes = "发票列表")
	public R queryReceipt(@ApiParam(value = "发票号") @RequestParam String receiptId,@ApiParam(value = "申请单号") @RequestParam  String requestId){
		return R.data(receiptService.receiptList(receiptId,requestId));
	}

	@GetMapping("/printInvoice")
	@ApiOperation(value = "单号打印", notes = "单号打印")
	public R printInvoice(@ApiParam(value = "旧单号")String requestId, @ApiParam(value = "新单号")String receiptId){
		String username = "操作人名字";
		return R.status(receiptService.printInvoice(receiptId,requestId,username));
	}
}

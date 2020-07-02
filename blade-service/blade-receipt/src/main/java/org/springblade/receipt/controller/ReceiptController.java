package org.springblade.receipt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.common.utils.CommonUtil;
import org.springblade.core.tool.api.R;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.ReceiptVo;
import org.springblade.receipt.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发票业务
 */
@Api(value = "发票接口", tags = "发票接口")
@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ReceiptController {

	private ReceiptService receiptService;

	@PostMapping("/queryRequestDetailReceipt")
	@ApiOperation(value = "发票号列表", notes = "发票号列表")
	public R queryRequestDetailReceipt(@ApiParam(value = "发票号集合") @RequestBody List<String> requestIds) {
		return R.data(receiptService.queryRequestDetailReceipt(requestIds));
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

	@PostMapping("/printInvoice")
	@ApiOperation(value = "保存并打印发票", notes = "发票打印")
	public R printInvoice(@RequestBody  List<ReceiptVo> receiptVo){
		String username = "操作人名字";
		return R.status(receiptService.printInvoice(receiptVo,username));
	}

	@GetMapping("/refund")
	@ApiOperation(value = "退款",notes = "退款")
	public R Refund(@ApiParam(value = "申请单号") String requestId,@ApiParam(value = "退款理由")String reason){
		String username = "";
		return R.data(receiptService.refund(requestId,username,reason));
	}


}

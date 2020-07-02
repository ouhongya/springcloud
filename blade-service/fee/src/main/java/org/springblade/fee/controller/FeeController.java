package org.springblade.fee.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.Feedetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
@AllArgsConstructor
public class FeeController {

	private FeeService feeService;


	/**
	 * 获取患者申请单列表
	 */
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "申请单列表", notes = "传入申请单列表id（数组） request_id_list")
	@PostMapping("/queryapplicationfromlist")
	public R<List<Fee>> queryapplicationfrom(@RequestBody List<Long> request_id_list) {
		 List<Fee> queryapplicationfrom = feeService.queryapplicationfrom(request_id_list);
         return R.data(queryapplicationfrom);
	}

	/**
	 * 获取患者项目明细
	 */
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "项目明细", notes = "传入申请单列表id request_id")
	@PostMapping("/queryapplication")
	public List<Feedetail> queryapplication(Long request_id) {
		List<Feedetail> queryapplication = feeService.queryapplication(request_id);
		return queryapplication;

	}

	/**
	 * 新增
	 */
	@PostMapping("/submitapplicationform")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "新增申请单", notes = "传入Applicationfrom")
	public R submit(@RequestBody RequestChargeInfo requestChargeInfo) {
		return R.status(feeService.submit(requestChargeInfo));
	}

	/**
	 * 修改
	 */
	@PostMapping("/updateapplicationform")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "修改", notes = "传入Applicationfrom")
	public R update(@RequestBody RequestChargeInfo requestChargeInfo) {

		return R.status(feeService.updateApplicationfrom(requestChargeInfo));
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "删除", notes = "传入申请单(list)id")
	public R remove(@RequestBody List<Long> request_id_list) {
		return R.status(feeService.removeApplicationfrom(request_id_list));
	}




}

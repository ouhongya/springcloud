package org.springblade.sysettings.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.dictchargestatus.DictChargeStatus;
import org.springblade.sysettings.service.ISysettingService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class SysettingsController {
	private ISysettingService ISysettingService;

	@GetMapping("info")
	public String info(String name) {
		return "Hello, My Name Is: " + name;
	}

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "支付状态字典表", notes = "支付状态字典表")
	public R selectAll() {
		return R.data(ISysettingService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "支付状态字典表", notes = "支付状态字典表")
	public R selectById(@ApiParam(value = "状态代码") Long id) {
		return R.data(ISysettingService.selectById(id));
	}

	/**
	 * [根据id删除]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/delById")
	@ApiOperation(value = "支付状态字典表", notes = "支付状态字典表")
	public R delById(@ApiParam(value = "状态代码") Long id) {
		return R.data(ISysettingService.delById(id));
	}

	/**
	 * [根据id修改]
	 *
	 * @param dictChargeStatus
	 * @return
	 */
	@GetMapping("/updateById")
	@ApiOperation(value = "支付状态字典表", notes = "支付状态字典表")
	public R updateById(@ApiParam(value = "状态代码") DictChargeStatus dictChargeStatus) {
		return R.data(ISysettingService.updateByIds(dictChargeStatus));
	}

	/**
	 * [新增数据]
	 *
	 * @param dictChargeStatus
	 * @return
	 */
	@GetMapping("/save")
	@ApiOperation(value = "支付状态字典表", notes = "支付状态字典表")
	public R save(@ApiParam(value = "状态代码") DictChargeStatus dictChargeStatus) {
		return R.data(ISysettingService.insert(dictChargeStatus));
	}

}

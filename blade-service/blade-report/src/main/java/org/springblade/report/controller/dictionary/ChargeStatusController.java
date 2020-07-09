package org.springblade.report.controller.dictionary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.dictionary.DictChargeStatus;
import org.springblade.report.service.IChargeStatusService;
import org.springframework.web.bind.annotation.*;

@Api(value = "支付状态字典表", tags = "支付状态字典表")
@RequestMapping("/api/chargeStatus")
@RestController
@AllArgsConstructor
public class ChargeStatusController {
	private IChargeStatusService iChargeStatusService;

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "查询所有", notes = "支付状态字典表")
	public R selectAll() {
		return R.data(iChargeStatusService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "根据id查询", notes = "支付状态字典表")
	public R selectById(@ApiParam(value = "状态代码") Long id) {
		return R.data(iChargeStatusService.selectById(id));
	}

	/**
	 * [新增数据]
	 *
	 * @param dictChargeStatus
	 * @return
	 */
	@GetMapping("/save")
	@ApiOperation(value = "新增数据", notes = "支付状态字典表")
	public R save(@ApiParam(value = "状态代码") DictChargeStatus dictChargeStatus) {
		return R.data(iChargeStatusService.insert(dictChargeStatus));
	}

}

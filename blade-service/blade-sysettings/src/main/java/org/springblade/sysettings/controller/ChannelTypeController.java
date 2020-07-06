package org.springblade.sysettings.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.dictionary.DictChannelType;
import org.springblade.sysettings.service.IChannelTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "支付渠道字典表", tags = "支付渠道字典表")
@RequestMapping("/api/channelType")
@RestController
@AllArgsConstructor
public class ChannelTypeController {
	private IChannelTypeService iChannelTypeService;

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "查询所有", notes = "支付渠道字典表")
	public R selectAll() {
		return R.data(iChannelTypeService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "根据id查询", notes = "支付渠道字典表")
	public R selectById(@ApiParam(value = "状态代码") Integer id) {
		return R.data(iChannelTypeService.selectById(id));
	}

	/**
	 * [根据id修改]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/updateById")
	@ApiOperation(value = "根据id修改", notes = "支付渠道字典表")
	public R updateById(@ApiParam(value = "状态代码") DictChannelType dictChannelType) {
		return R.data(iChannelTypeService.updateByIds(dictChannelType));
	}

	/**
	 * [新增数据]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/save")
	@ApiOperation(value = "新增数据", notes = "支付渠道字典表")
	public R save(@ApiParam(value = "状态代码") DictChannelType dictChannelType) {
		return R.data(iChannelTypeService.insert(dictChannelType));
	}

}

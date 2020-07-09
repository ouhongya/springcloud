package org.springblade.report.controller.dictionary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.dictionary.ExpiryDate;
import org.springblade.report.service.IExpiryDateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "项目有效期天数字典表", tags = "项目有效期天数字典表")
@RequestMapping("/api/expiry")
@RestController
@AllArgsConstructor
public class ExpiryDateController {
	private IExpiryDateService iExpiryDateService;

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "查询所有", notes = "项目有效期天数字典表")
	public R selectAll() {
		return R.data(iExpiryDateService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "根据id查询", notes = "项目有效期天数字典表")
	public R selectById(@ApiParam(value = "有效期主键") Integer id) {
		return R.data(iExpiryDateService.selectById(id));
	}

	/**
	 * [根据id修改]
	 *
	 * @param
	 * @return
	 */
	@PostMapping("/updateById")
	@ApiOperation(value = "根据id修改", notes = "项目有效期天数字典表")
	public R updateById(@ApiParam(value = "有效期主键") ExpiryDate expiryDate) {
		return R.data(iExpiryDateService.updateByIds(expiryDate));
	}

	/**
	 * [新增数据]
	 *
	 * @param
	 * @return
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增数据", notes = "项目有效期天数字典表")
	public R save(@ApiParam(value = "有效期主键") ExpiryDate expiryDate) {
		return R.data(iExpiryDateService.insert(expiryDate));
	}

}

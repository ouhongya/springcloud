package org.springblade.sysettings.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.dictionary.Category;
import org.springblade.sysettings.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "费用类别字典表", tags = "费用类别字典表")
@RequestMapping("/api/category")
@RestController
@AllArgsConstructor
public class CategoryController {
	private ICategoryService iCategoryService;

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "查询所有", notes = "费用类别字典表")
	public R selectAll() {
		return R.data(iCategoryService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "根据id查询", notes = "费用类别字典表")
	public R selectById(@ApiParam(value = "费用类别id") Long categoryId) {
		return R.data(iCategoryService.selectById(categoryId));
	}

	/**
	 * [新增数据]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/save")
	@ApiOperation(value = "新增数据", notes = "费用类别字典表")
	public R save(@ApiParam(value = "费用类别") Category category) {
		return R.data(iCategoryService.insert(category));
	}

}

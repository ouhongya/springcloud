package org.springblade.sysettings.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.dictionary.DictRequestType;
import org.springblade.sysettings.service.IRequestTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/requestType")
@RestController
@AllArgsConstructor
public class RequestTypeController {
	private IRequestTypeService iRequestTypeService;

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
	@ApiOperation(value = "申请单类别字典表", notes = "申请单类别字典表")
	public R selectAll() {
		return R.data(iRequestTypeService.selectAll());
	}

	/**
	 * [根据id查询]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "申请单类别字典表", notes = "申请单类别字典表")
	public R selectById(@ApiParam(value = "状态代码") Integer id) {
		return R.data(iRequestTypeService.selectById(id));
	}

	/**
	 * [根据id删除]
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/delById")
	@ApiOperation(value = "申请单类别字典表", notes = "申请单类别字典表")
	public R delById(@ApiParam(value = "状态代码") Integer id) {
		return R.data(iRequestTypeService.delById(id));
	}

	/**
	 * [根据id修改]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/updateById")
	@ApiOperation(value = "申请单类别字典表", notes = "申请单类别字典表")
	public R updateById(@ApiParam(value = "状态代码") DictRequestType dictRequestType) {
		return R.data(iRequestTypeService.updateByIds(dictRequestType));
	}

	/**
	 * [新增数据]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/save")
	@ApiOperation(value = "申请单类别字典表", notes = "申请单类别字典表")
	public R save(@ApiParam(value = "状态代码") DictRequestType dictRequestType) {
		return R.data(iRequestTypeService.insert(dictRequestType));
	}

}

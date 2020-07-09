package org.springblade.report.controller.dictionary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.dictionary.DictRequestType;
import org.springblade.report.service.IRequestTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "申请单类别字典表", tags = "申请单类别字典表")
@RequestMapping("/api/requestType")
@RestController
@AllArgsConstructor
public class RequestTypeController {
	private IRequestTypeService iRequestTypeService;

	/**
	 * [查询所有]
	 *
	 * @return
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "查询所有", notes = "申请单类别字典表")
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
	@ApiOperation(value = "根据id查询", notes = "申请单类别字典表")
	public R selectById(@ApiParam(value = "状态代码") Integer id) {
		return R.data(iRequestTypeService.selectById(id));
	}


	/**
	 * [根据id修改]
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/updateById")
	@ApiOperation(value = "根据id修改", notes = "申请单类别字典表")
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
	@ApiOperation(value = "新增数据", notes = "申请单类别字典表")
	public R save(@ApiParam(value = "状态代码") DictRequestType dictRequestType) {
		return R.data(iRequestTypeService.insert(dictRequestType));
	}

}
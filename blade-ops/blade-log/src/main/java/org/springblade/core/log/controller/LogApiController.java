/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.core.log.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springblade.core.log.model.LogApi;
import org.springblade.core.log.model.LogApiVo;
import org.springblade.core.log.service.ILogApiService;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 控制器
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class LogApiController {

	private ILogApiService logService;

	/**
	 * 查询单条
	 */
	@GetMapping("/detail")
	public R<LogApi> detail(LogApi log) {
		return R.data(logService.getOne(Condition.getQueryWrapper(log)));
	}

	/**
	 * 查询多条(分页)
	 */
	@GetMapping("/list")
	public R<IPage<LogApiVo>> list(@ApiIgnore @RequestParam Map<String, Object> log, Query query) {
		IPage<LogApi> pages = logService.page(Condition.getPage(query.setDescs("create_time")), Condition.getQueryWrapper(log, LogApi.class));
		List<LogApiVo> records = pages.getRecords().stream().map(logApi -> {
			LogApiVo vo = BeanUtil.copy(logApi, LogApiVo.class);
			vo.setStrId(Func.toStr(logApi.getId()));
			return vo;
		}).collect(Collectors.toList());
		IPage<LogApiVo> pageVo = new Page<>(pages.getCurrent(), pages.getSize(), pages.getTotal());
		pageVo.setRecords(records);
		return R.data(pageVo);
	}

}

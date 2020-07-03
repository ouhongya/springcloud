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
package org.springblade.fee.feign;



import org.springblade.core.tool.api.R;
import org.springblade.fee.vo.FavorItemBrief;
import org.springblade.fee.vo.FavorPatientBrief;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Fee Feign接口类
 *
 * @author Chill
 */
@FeignClient(value = "fee")
public interface IFeeClient {

	String API_PREFIX = "/dept-market";
	String PATIENT_FAVOR = API_PREFIX + "/get-patient-favor";
	String ITEM_FAVOR = API_PREFIX + "/get-item-favor";

	/**
	 * 患者优惠信息请求接口
	 *
	 * @param
	 * @return
	 */
	@GetMapping(PATIENT_FAVOR)
	R<FavorPatientBrief> patient_favor(@RequestParam("patient_id") Long patient_id);

	/**
	 * 项目优惠信息请求接口
	 *
	 * @param
	 * @param
	 * @return
	 */
	@GetMapping(ITEM_FAVOR)
	R<FavorItemBrief> item_favor(@RequestParam("patient_id") Long patient_id, @RequestParam(value = "item_id[]") Integer[] item_id);

}

package org.springblade.fee.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.PatientBriefData;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("api")
@AllArgsConstructor
public class FeeController {

	private FeeService feeService;

	/**
	 * 获取患者信息
	 */
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "患者信息", notes = "传入患者 patient_id，申请单列表数组 request_id_list")
	@GetMapping("/pagecharge")
	public R<PatientBriefData> pagecharge(Long  patient_id) {
		PatientBriefData patientBriefData = feeService.queryPatientBriefData(patient_id);
		return R.data(patientBriefData);
	}


	/**
	 * 获取患者申请单列表
	 */
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "申请单列表", notes = "传入患者 patient_id")
	@GetMapping("/queryapplicationfrom")
	public R<List<Fee>> queryapplicationfrom(@RequestBody List<Long> request_id_list) {
		 List<Fee> queryapplicationfrom = feeService.queryapplicationfrom(request_id_list);
         return R.data(queryapplicationfrom);
	}



}

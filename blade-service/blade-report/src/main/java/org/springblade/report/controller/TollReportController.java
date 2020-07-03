package org.springblade.report.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.service.ITollReportService;
import org.springframework.web.bind.annotation.*;

/**
 * [统计报表--收费人员]
 *
 * @Author create by
 * @date 2020/7/2-14:28
 */
@RequestMapping("/api/toll")
@RestController
@AllArgsConstructor
public class TollReportController {
	private ITollReportService iTollReportService;

	@GetMapping("info")
	public String info(String name) {
		return "Hello rptdetail ,My Name Is: " + name;
	}

	/**
	 * [报表-明细数据]
	 *
	 * @return
	 */
	@PostMapping("/rptdetail")
	@ApiOperation(value = "报表明细", notes = "报表明细")
	public R rptDetail() {
//		Integer toll_collector_id = "收费人员id";
		Integer toll_collector_id = 1;
		return R.data(iTollReportService.rptdetail(toll_collector_id));
	}

	/**
	 * [收费统计]
	 *
	 * @return
	 */
	@PostMapping("/chargeStatistics")
	@ApiOperation(value = "收费统计", notes = "收费统计")
	public R chargeStatistics() {
//		Integer toll_collector_id = "收费人员id";
		Integer toll_collector_id = 1;
		return R.data(iTollReportService.chargeStatistics(toll_collector_id));
	}

}

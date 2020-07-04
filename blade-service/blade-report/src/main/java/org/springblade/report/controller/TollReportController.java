package org.springblade.report.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.ReportDetail;
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
	@PostMapping("/tolldetail")
	@ApiOperation(value = "报表明细", notes = "报表明细")
	public R rptDetail(ReportDetail reportDetail) {
//		Integer toll_collector_id = "收费人员id";
		reportDetail.setTollCollectorId(1);
		reportDetail.setTurnStatus(0);
		return R.data(iTollReportService.rptdetail(reportDetail));
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

//	/**
//	 * [财务上交]
//	 *
//	 * @return
//	 */
//	@PostMapping("/financialTurnIn")
//	@ApiOperation(value = "财务上交", notes = "财务上交")
//	public R financialTurnIn(Integer[] id) {
//		return R.data(iTollReportService.financialTurnIn(id));
//	}

}

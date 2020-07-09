package org.springblade.report.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.report.ReportDetail;
import org.springblade.report.service.ITollReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * [统计报表---财务人员]
 *
 * @Author create by
 * @date 2020/7/2-14:34
 */
@Api(value = "统计报表---财务人员", tags = "统计报表---财务人员")
@RequestMapping("/api/finance")
@RestController
@AllArgsConstructor
public class FinanceReportController {
	private ITollReportService iTollReportService;

	/**
	 * [报表-明细数据]
	 *
	 * @return
	 */
	@PostMapping("/rptDetail")
	@ApiOperation(value = "报表明细", notes = "报表明细")
	public R rptDetail(ReportDetail reportDetail) {
		reportDetail.setTurnStatus(1); //是否统计上交
		return R.data(iTollReportService.rptdetail(reportDetail));
	}


	/**
	 * [收费统计]
	 *
	 * @param tollCollectorId
	 * @return
	 */
	@PostMapping("/finaCharge")
	@ApiOperation(value = "收费统计", notes = "收费统计")
	public R finaCharge(Integer tollCollectorId, Integer turnStatus) {
		return R.data(iTollReportService.chargeStatistics(tollCollectorId, turnStatus));
	}


	/**
	 * [报表-预览报表]
	 *
	 * @return
	 */
	@PostMapping("/viewReport")
	@ApiOperation(value = "预览报表", notes = "预览报表")
	public R viewReport(ReportDetail reportDetail) {
		return R.data(iTollReportService.viewReport(reportDetail));
	}

}

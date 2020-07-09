package org.springblade.report.controller.report;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.report.ReportDetail;
import org.springblade.report.service.ITollReportService;
import org.springframework.web.bind.annotation.*;


/**
 * [统计报表--收费人员]
 *
 * @Author create by
 * @date 2020/7/2-14:28
 */
@Api(value = "统计报表---收费人员", tags = "统计报表---收费人员")
@RequestMapping("/api/toll")
@RestController
@AllArgsConstructor
public class TollReportController {
	private ITollReportService iTollReportService;

	/**
	 * [报表-明细数据]
	 *
	 * @return
	 */
	@PostMapping("/tolldetail")
	@ApiOperation(value = "报表明细", notes = "报表明细")
	public R rptDetail(ReportDetail reportDetail) {
		reportDetail.setTurnStatus(0); //是否统计上交
		return R.data(iTollReportService.rptdetail(reportDetail));
	}

	/**
	 * [收费统计]
	 *
	 * @return
	 */
	@PostMapping("/finaCharge")
	@ApiOperation(value = "收费统计", notes = "收费统计")
	public R chargeStatistics(Integer tollCollectorId, Integer turnStatus) {
		return R.data(iTollReportService.chargeStatistics(tollCollectorId, turnStatus));
	}

	/**
	 * [财务上交---修改统计上交状态]
	 *
	 * @return
	 */
	@PostMapping("/updateTurnStatus")
	@ApiOperation(value = "财务上交--根据id修改,多个id传数组", notes = "财务上交")
	public R updateTurnStatus(Integer[] ids) {
		String msg = iTollReportService.updateTurnStatus(ids);
		return R.success(msg);
	}

	/**
	 * [根据id查询收费记录表]
	 */
	@GetMapping("/selectById")
	@ApiOperation(value = "根据id查询收费记录表", notes = "根据id查询收费记录表")
	public R selectById(Integer id) {
		return R.data(iTollReportService.selectById(id));
	}
}

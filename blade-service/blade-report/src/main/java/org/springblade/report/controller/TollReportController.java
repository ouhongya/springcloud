package org.springblade.report.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.ReportDetail;
import org.springblade.report.service.ITollReportService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String times = "2020-06-30 15:33:41";
		//获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//使用SimpleDateFormat的parse()方法生成Date
		try {
			Date date = sf.parse(times);
			reportDetail.setPaidTime(date);
			System.out.println(date);
			System.out.println(reportDetail.getPaidTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

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

	/**
	 * [财务上交---修改统计上交状态]
	 *
	 * @return
	 */
	@PostMapping("/updateTurnStatus")
	@ApiOperation(value = "财务上交", notes = "财务上交")
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

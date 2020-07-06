package org.springblade.report.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.report.ReportDetail;
import org.springblade.report.service.ITollReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@GetMapping("info")
	public String info(String name) {
		return "Hello finance ,My Name Is: " + name;
	}

	/**
	 * [报表-明细数据]
	 *
	 * @return
	 */
	@PostMapping("/finadetail")
	@ApiOperation(value = "报表明细", notes = "报表明细")
	public R rptDetail(ReportDetail reportDetail) {
//		Integer toll_collector_id = "收费人员id";
		reportDetail.setTollCollectorId(1);  //收费人员
		reportDetail.setTurnStatus(0);  //是否统计上交
		String ope = "2020-06-30 00:33:41";
		String end = "2020-06-30 15:33:41";
		//获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//使用SimpleDateFormat的parse()方法生成Date
		try {
			Date opedate = sf.parse(ope);
			Date enddate = sf.parse(end);
			reportDetail.setCreateTime(opedate);
			reportDetail.setPaidTime(enddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		/**
//		 * 收费统计
//		 */
//		finacharge(reportDetail.getTollCollectorId());
		return R.data(iTollReportService.rptdetail(reportDetail));
	}


	/**
	 * [收费统计]
	 *
	 * @param tollCollectorId
	 * @return
	 */
	@PostMapping("/finacharge")
	@ApiOperation(value = "收费统计", notes = "收费统计")
	public R finacharge(Integer tollCollectorId) {
//		Integer toll_collector_id = "收费人员id";
		tollCollectorId = 1;
		return R.data(iTollReportService.chargeStatistics(tollCollectorId));
	}
}

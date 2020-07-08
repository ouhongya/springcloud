package org.springblade.report.service;

import org.springblade.report.ChargestsList;
import org.springblade.report.RecordCharge;
import org.springblade.report.ReportDetail;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/3-11:58
 */
public interface ITollReportService {

	List<ReportDetail> rptdetail(ReportDetail reportDetail);

	List<ChargestsList> chargeStatistics(Integer toll_collector_id,Integer turnStatus);

	RecordCharge selectById(Integer id);

	String updateTurnStatus(Integer[] ids);

	List<ReportDetail> viewReport(ReportDetail reportDetail);
}

package org.springblade.report.mapper.report;

import org.apache.ibatis.annotations.Param;
import org.springblade.report.entity.report.ChargestsList;
import org.springblade.report.entity.report.ReportRecords;
import org.springblade.report.entity.report.ReportDetail;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/3-12:00
 */
public interface TollReportMapper {

	List<ChargestsList> chargeStatistics(@Param("toll_collector_id") Integer toll_collector_id, @Param("turnStatus")Integer turnStatus);

	List<ReportDetail> rptdetail(ReportDetail reportDetail);

	ReportRecords selectById(@Param("id") Integer id);

	int updateTurnStatus(@Param("id")Integer id);

    List<ReportDetail> totalViewReport(ReportDetail reportDetail);
}

package org.springblade.report.service;

import org.springblade.report.ChargestsList;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/3-11:58
 */
public interface ITollReportService {

	Object rptdetail(Integer toll_collector_id);

	List<ChargestsList> chargeStatistics(Integer toll_collector_id);
}

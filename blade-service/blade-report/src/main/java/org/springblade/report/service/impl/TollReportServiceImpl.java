package org.springblade.report.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.report.ChargestsList;
import org.springblade.report.ReportDetail;
import org.springblade.report.mapper.TollReportMapper;
import org.springblade.report.service.ITollReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author create by
 * @date 2020/7/3-11:59
 */
@Slf4j
@Service
@AllArgsConstructor
public class TollReportServiceImpl implements ITollReportService {
	private TollReportMapper tollReportMapper;

	@Override
	public List<ReportDetail> rptdetail(ReportDetail reportDetail) {
		return tollReportMapper.rptdetail(reportDetail);
	}

	@Override
	public List<ChargestsList> chargeStatistics(Integer toll_collector_id) {
		List<ChargestsList> list = tollReportMapper.chargeStatistics(toll_collector_id);
		BigDecimal payTypeMoney = list.get(0).getPayTypeMoney();
		BigDecimal refund = list.get(0).getRefund();
		BigDecimal actuallyPay = payTypeMoney.subtract(refund); //实际上缴金额
		list.get(0).setActuallyPay(actuallyPay);
		return list;
	}
}

package org.springblade.report.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springblade.report.ChargestsList;
import org.springblade.report.RecordCharge;
import org.springblade.report.ReportDetail;
import org.springblade.report.mapper.TollReportMapper;
import org.springblade.report.service.ITollReportService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
		BigDecimal totalMoney = list.get(0).getTotalMoney();//实收总金额
		BigDecimal refund = list.get(0).getRefund();
		BigDecimal actuallyPay = totalMoney.subtract(refund); //实际上缴金额
		list.get(0).setActuallyPay(actuallyPay);
		return list;
	}

	@Override
	public String updateTurnStatus(Integer[] ids) {
		String str = "";
		for (Integer id : ids) {
			//根据id查询记录是否存在
			RecordCharge recordCharge = tollReportMapper.selectById(id);
			if (!ObjectUtils.isEmpty(recordCharge)) {
				tollReportMapper.updateTurnStatus(id);
				str = "操作成功";
			} else {
				str = "操作失败,未查询到该数据";
			}
		}
		return str;
	}

	@Override
	public RecordCharge selectById(Integer id) {
		return tollReportMapper.selectById(id);
	}

}

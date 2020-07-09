package org.springblade.report.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.report.entity.report.ChargestsList;
import org.springblade.report.entity.report.ReportRecords;
import org.springblade.report.entity.report.ReportDetail;
import org.springblade.report.mapper.TollReportMapper;
import org.springblade.report.service.ITollReportService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//		reportDetail.setTollCollectorId(1);  //收费人员
//		String ope = "2020-06-30 00:33:41";
//		String end = "2020-06-30 15:33:41";
		//获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		//使用SimpleDateFormat的parse()方法生成Date
//		try {
//			Date opedate = sf.parse(ope);
//			Date enddate = sf.parse(end);
//			reportDetail.setCreateTime(opedate);
//			reportDetail.setPaidTime(enddate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

		return tollReportMapper.rptdetail(reportDetail);
	}

	@Override
	public List<ChargestsList> chargeStatistics(Integer toll_collector_id, Integer turnStatus) {
		List<ChargestsList> list = tollReportMapper.chargeStatistics(toll_collector_id, turnStatus);
		if (list.size() > 0) {
			BigDecimal totalMoney = list.get(0).getTotalMoney();//实收总金额
			BigDecimal refund = list.get(0).getRefund();
			BigDecimal actuallyPay = totalMoney.subtract(refund); //实际上缴金额
			list.get(0).setActuallyPay(actuallyPay);
			return list;
		} else {
			return null;
		}

	}

	@Override
	public String updateTurnStatus(Integer[] ids) {
		String str = "";
		for (Integer id : ids) {
			//根据id查询记录是否存在
			ReportRecords recordCharge = tollReportMapper.selectById(id);
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
	public ReportRecords selectById(Integer id) {
		return tollReportMapper.selectById(id);
	}


	@Override
	public List<ReportDetail> viewReport(ReportDetail reportDetail) {
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
		return tollReportMapper.totalViewReport(reportDetail);
	}


}

package org.springblade.report.mapper;

import org.apache.ibatis.annotations.Param;
import org.springblade.report.ChargestsList;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/3-12:00
 */
public interface TollReportMapper {

	List<ChargestsList> chargeStatistics(@Param("toll_collector_id") Integer toll_collector_id);
}
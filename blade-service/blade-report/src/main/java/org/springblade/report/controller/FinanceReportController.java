package org.springblade.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [统计报表---财务人员]
 *
 * @Author create by yaodan
 * @date 2020/7/2-14:34
 */
@RequestMapping("/api/finance")
@RestController
@AllArgsConstructor
public class FinanceReportController {
	@GetMapping("info")
	public String info(String name) {
		return "Hello finance ,My Name Is: " + name;
	}
}

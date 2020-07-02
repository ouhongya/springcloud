package org.springblade.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [统计报表--收费人员]
 *
 * @Author create by yaodan
 * @date 2020/7/2-14:28
 */
@RequestMapping("/api/toll")
@RestController
@AllArgsConstructor
public class TollReportController {
	@GetMapping("info")
	public String info(String name) {
		return "Hello toll ,My Name Is: " + name;
	}
}

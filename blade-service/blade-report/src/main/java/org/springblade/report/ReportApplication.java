package org.springblade.report;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
@EnableScheduling
public class ReportApplication {
	public static void main(String[] args) {
		BladeApplication.run("blade-report", ReportApplication.class, args);
	}
}

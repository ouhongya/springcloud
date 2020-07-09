package org.springblade.receipt;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
@ComponentScan(basePackages = "org.springblade.receipt.entity")
public class ReceiptApplication {
	public static void main(String[] args) {
		BladeApplication.run("blade-receipt", ReceiptApplication.class, args);
	}

}

package org.springblade.receipt;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class ReceiptApplication {
	public static void main(String[] args) {
		BladeApplication.run("blade-receipt", ReceiptApplication.class, args);
	}
}

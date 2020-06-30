package org.springblade.receipt;

import org.springblade.common.constant.CommonConstant;
import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class ReceiptApplication {
	public static void main(String[] args) {
		BladeApplication.run(CommonConstant.APPLICATION_RECEIPT_NAME, ReceiptApplication.class, args);
	}
}

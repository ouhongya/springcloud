package org.springblade.sysettings;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class SysettingsApplication {
	public static void main(String[] args) {
		BladeApplication.run("blade-sysettings", SysettingsApplication.class, args);
	}
}

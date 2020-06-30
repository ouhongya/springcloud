package org.springblade.receipt.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("/")
public interface IUserClient {

	@GetMapping("")
	List<String> permissionPath(@RequestParam("roleId") String roleId);
}

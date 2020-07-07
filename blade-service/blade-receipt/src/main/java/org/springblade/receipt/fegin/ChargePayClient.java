package org.springblade.receipt.fegin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server")
public interface ChargePayClient {

}

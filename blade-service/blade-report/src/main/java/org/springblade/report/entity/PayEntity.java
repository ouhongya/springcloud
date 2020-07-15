package org.springblade.report.entity;

import lombok.Data;
import org.springblade.fee.vo.FeeRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PayEntity {
	Long charge_id;
	Integer channel_id;
	List<FeeRequest> feeRequest;
	BigDecimal fee_paid;
	Integer checked;
}

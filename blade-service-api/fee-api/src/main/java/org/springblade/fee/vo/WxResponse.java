package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class WxResponse implements Serializable {


	private static final long serialVersionUID = 4852155688223493983L;

	List<FeeRequest> feeRequest;

	Integer checked;

	Long charge_id;

	BigDecimal fee_paid;
}

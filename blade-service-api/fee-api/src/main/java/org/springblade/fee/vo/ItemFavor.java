package org.springblade.fee.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemFavor {
	//收费项目id
	private int item_id;

	//优惠id
	private int favor_id;

	//优惠渠道名称
	private String favor_name;

	//优惠费用
	private String fee_favor;

	//申请单id
	private long request_id;

	//实收费用
	private BigDecimal fee_final;

}

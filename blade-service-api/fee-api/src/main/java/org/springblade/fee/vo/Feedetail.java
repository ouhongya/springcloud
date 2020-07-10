package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Feedetail implements Serializable {

	private static final long serialVersionUID = 3023425485816592252L;

	//申请单id
	private long requestId;

	//收费项目id
	private int itemId;

	//收费项目类别id
	private int itemTypeId;

	//数量
	private int itemCount;

	//开单科室ID
	private int dept_id;

	//优惠id
	private int favorId;

	//优惠渠道名称
	private String favorName;

	//优惠费用
	private String feeFavor;

	//项目费用
	private BigDecimal feeItem;

	//实收费用
	private BigDecimal feeFinal;

	//优惠渠道id
	private int favorChannelId;

	//优惠渠道名称
	private String favorChanne;

	//执行科室id
	private int executeDeptId;

	//退费原因
	private String refundReason;

	//支付状态
	private byte status;


}

package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class  Fee  implements Serializable {
	private static final long serialVersionUID = 8923300639329184713L;

	//申请单id
	private long requestId;

	//收费项目id
	private int itemId;

	//收费项目类型
	private int itemType;

	//数量
	private int itemCount;

	//项目费用
	private BigDecimal feeItem;

	//优惠费用
	private BigDecimal feeFavor;

	//实收费用
	private BigDecimal feeFinal;

	//优惠渠道id
	private int favorChannelId;

	//优惠名称
	private String favorChannel;

	//执行科室id
	private int executeDeptId;

	//支付状态
	private byte status;

	//退款原因
	private String refundReason;

	//患者id
	private long patientId;

	//申请单类别
	private int requestType;

	//收费记录id
	private long chargeId;

	//开单科室id
	private int deptId;

	//开单医生id
	private int doctorId;
}

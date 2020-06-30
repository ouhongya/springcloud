package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.tenant.mp.TenantEntity;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@TableName("request_detail")
@EqualsAndHashCode(callSuper = true)
public class Applicationfrom extends TenantEntity implements Serializable {
	private static final long serialVersionUID = 4960906956349450003L;

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

}




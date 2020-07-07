package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("charge_pay")
public class ChargePay  implements Serializable {

	private static final long serialVersionUID = 2439232306246824135L;

	//支付记录ID
	private int id;

	//支付渠道代码
	private int channel_type_id;

	//用户支付订单号:该次支付在第三方平台的订单号,支付渠道为现金时该项为空
	private String  channel_order;

	//用户支付账户:银行卡账号,第三方支付账号,支付渠道为现金时直接填写:现金
	private String channel_account;

	//收费记录id
	private long charge_id;

	//实收金额
	private BigDecimal fee_paid;

	//已退款金额
	private BigDecimal fee_refund;

	//收款时间
	private Date paid_time;

	//退款时间
	private Date refund_time;

	//支付状态
	private byte status;
}




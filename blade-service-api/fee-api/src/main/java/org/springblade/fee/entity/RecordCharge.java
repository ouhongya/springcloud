package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springblade.core.tenant.mp.TenantEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@TableName("record_charge")
public class RecordCharge extends TenantEntity implements Serializable {

	private static final long serialVersionUID = -3233311081557697815L;

//	//收费记录id
//	private long id;

	//患者id
	private long patientId;

	//申请单列表ids
	private List<Long> request_id_list;

	//收费记录创建时间
	private Date createTime;

	//支付完成时间
	private Date paidTime;

	//退款时间
	private Date refundTime;

	//优惠渠道id
	private int favor_channel_id;

	//优惠渠道名称
	private String favor_channel;

	//优惠费用
	private BigDecimal favor_fee;

//	//支付状态
//	private byte status;

	//收费员id
	private long tollCollectorId;

	//优惠金额
	private double money;

	//优惠原因
	private String reason;

	//开始时间
	private Date start_time;

	//截至时间
	private Date end_time;

	//0  未上交 1  已上交
	private int turnStatus;

	//费用类别
	private byte categoryId;


	//收费记录id
	private int charge_id;






}




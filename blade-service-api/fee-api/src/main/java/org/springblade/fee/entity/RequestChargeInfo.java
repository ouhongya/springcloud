package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.tenant.mp.TenantEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@TableName("request_detail")
public class RequestChargeInfo extends TenantEntity implements Serializable {

	private static final long serialVersionUID = 4960906956349450003L;

	//申请单id
	private long requestId;

	//患者id
	private long patientId;

	//申请单类别id
	private int requestTypeId;

	//开单科室id
	private int deptId;

	//开单医生id
	private int doctorId;

	//token
	private String token;

	//secret
	private String secret;


	//申请单所含项目
	private List<ItemCount> item_list;
}




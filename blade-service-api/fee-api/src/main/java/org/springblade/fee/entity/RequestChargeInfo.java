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
	private long request_id;

	//患者id
	private long patient_id;

	//申请单类别id
	private int request_type_id;

	//token
	private String token;

	//token
	private String secret;


	//申请单所含项目
	private List<ItemCount> item_list;
}




package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springblade.core.tenant.mp.TenantEntity;

import java.io.Serializable;
import java.util.List;


@Data
@TableName("charge_request")
public class ChargeRequest extends TenantEntity implements Serializable {


	private static final long serialVersionUID = 8114552837482809405L;

	//申请单id
	private long request_id;

	//患者id
	private long patient_id;

	//申请单类别id
	private int request_type_id;

	//开单科室ID
	private int dept_id;

	//开单医生id
	private int doctor_id;

}




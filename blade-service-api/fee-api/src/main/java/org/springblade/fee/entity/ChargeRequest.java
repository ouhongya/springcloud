package org.springblade.fee.entity;


import lombok.Data;
import java.io.Serializable;



@Data
public class ChargeRequest  implements Serializable {


	private static final long serialVersionUID = 8114552837482809405L;

	//申请单id
	private long requestId;

	//患者id
	private long patientId;

	//申请单类别id
	private int requestType;

	//收费记录id
	private long chargeId;

	//开单科室ID
	private int deptId;

	//开单医生id
	private int doctorId;

}




package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class  Fee  implements Serializable {
	private static final long serialVersionUID = 8923300639329184713L;

	//申请单id
	private long requestId;

	//患者id
	private long patientId;

	//开单科室id
	private int deptId;

	//开单医生id
	private int doctorId;

	//申请单类别id
	private int requestTypeId;

	//申请单类别名称
	private String requestType;
}

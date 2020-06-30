package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StaffInfo implements Serializable {


	private static final long serialVersionUID = -2003571637156872198L;

	//用户id
	private int staff_id;

	//用户名
	private int name;

	//用户科室id
	private int dept_id;

	//用户医院id
	private int hospital_id;

	//用户角色id
	private int role_id;
}

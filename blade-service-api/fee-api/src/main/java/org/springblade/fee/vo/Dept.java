package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

	private static final long serialVersionUID = 2126581768183210471L;

	//科室id
	private int dept_id;

	//科室名称
	private String dept_name;


}

package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Favourable implements Serializable {


	private static final long serialVersionUID = 1103677126536134586L;

	//优惠原因
	private String reason;

	//优惠金额
	private double money;

}

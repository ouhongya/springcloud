package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DicRequestType implements Serializable {


	private static final long serialVersionUID = -7368074912826210041L;

	//类别代码id
	private int id;

	//类别名称
	private String text;

	//是否启用
	private int enabled;

}

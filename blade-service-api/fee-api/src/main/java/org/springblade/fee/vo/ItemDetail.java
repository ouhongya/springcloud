package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ItemDetail implements Serializable {

	private static final long serialVersionUID = 2790871970440634459L;

	//收费项目id
	private int item_id;
	//收费项目类别id
	private int item_type_id;
	//项目费用
	private BigDecimal fee;
	//项目名称
	private String name;
	//项目规格
	private String spec;
	//项目单位
	private String unit;
	//项目生成商家
	private String producer;
}




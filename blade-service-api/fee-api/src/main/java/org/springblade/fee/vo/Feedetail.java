package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Feedetail implements Serializable {


	private static final long serialVersionUID = 3023425485816592252L;

	//申请单id
	private long requestId;

	//收费项目id
	private int itemId;

	//收费项目类别id
	private int itemTypeId;

	//数量
	private int itemCount;

	//开单科室ID
	private int dept_id;
}

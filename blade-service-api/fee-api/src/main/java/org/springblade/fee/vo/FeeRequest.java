package org.springblade.fee.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FeeRequest implements Serializable {


	private static final long serialVersionUID = 5997695928922321232L;

	//申请单id
	private Long request_id;

	//申请单对应的收费项目id
	private List<Integer> item_id;

}

package org.springblade.fee.vo;

import lombok.Data;

import java.util.List;

@Data
public class FavorItemBrief {

	private long patient_id;

	//项目优惠集合
	private List<ItemFavor> favor_list;
}

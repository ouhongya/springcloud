package org.springblade.receipt.entity;

import org.springblade.core.mp.base.BaseEntity;

public class Fee extends BaseEntity {
	/**
	 * 标准响应
	 */
	class RespData {
		//响应状态码， 200为成功 400为失败
		private int status;

		//文本描述
		private String desc;
	}

	/**
	 * 标准响应扩展参数
	 */
	class RespDataWithLong extends RespData {
		private long long_value;
	}
}

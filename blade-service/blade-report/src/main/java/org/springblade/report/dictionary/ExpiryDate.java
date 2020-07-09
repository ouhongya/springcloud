package org.springblade.report.dictionary;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

/**
 * [项目有效期天数字典表---]
 *
 * @Author create by
 * @date 2020/7/1-15:40
 */
@Data
@TableName("expiry_date")
public class ExpiryDate extends BaseEntity implements Serializable {
	/**
	 * 有效期主键
	 */
	@ApiModelProperty(value = "有效期主键")
	private Long id;

	/**
	 * 项目有效期天数，过期作废
	 */
	@ApiModelProperty(value = "项目有效期天数，过期作废")
	private Integer validQuantum;


}

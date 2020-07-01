package org.springblade.dictionary;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

/**
 * [支付状态字典表--dict_charge_status]
 *
 * @Author create by yaodan
 * @date 2020/7/1-10:23
 */
@Data
@TableName("dict_charge_status")
public class DictChargeStatus extends BaseEntity implements Serializable {

	/**
	 * 状态代码
	 */
	@ApiModelProperty(value = "状态代码：0:待支付 1:支付完成,2:部分支付,3:可退款,4:有退款,5:作废")
	private Long id;
	/**
	 * 状态名称
	 */
	@ApiModelProperty(value = "状态名称")
	private String text;

}

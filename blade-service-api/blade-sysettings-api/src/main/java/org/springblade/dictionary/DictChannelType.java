package org.springblade.dictionary;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

/**
 *
 * [支付渠道字典表]
 * @Author create by yaodan
 * @date 2020/7/1-15:40
 */
@Data
@TableName("dict_channel_type")
public class DictChannelType extends BaseEntity implements Serializable {
	/**
	 * 状态代码
	 */
	@ApiModelProperty(value = "状态代码：1:现金 2:微信,3:支付宝,4:社保,5:银行卡")
	private Long id;
	/**
	 * 状态名称
	 */
	@ApiModelProperty(value = "状态名称")
	private String text;
	/**
	 * 是否启用
	 */
	private Integer enabled=0;
}

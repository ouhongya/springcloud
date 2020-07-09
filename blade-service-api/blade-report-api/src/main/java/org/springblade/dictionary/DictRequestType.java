package org.springblade.dictionary;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

/**
 *
 * [申请单类别字典表---]
 * @Author create by
 * @date 2020/7/1-15:40
 */
@Data
@TableName("dict_request_type")
public class DictRequestType extends BaseEntity implements Serializable {
	/**
	 * 状态代码
	 */
	@ApiModelProperty(value = "类别id:1,挂号 2,处方3,住院 4,检查 5,门诊")
	private Long id;
	/**
	 * 状态名称
	 */
	@ApiModelProperty(value = "类别名称")
	private String text;
	/**
	 * 是否启用
	 */
	private Integer enabled=0;


}

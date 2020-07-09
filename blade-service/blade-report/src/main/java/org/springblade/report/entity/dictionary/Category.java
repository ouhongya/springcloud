package org.springblade.report.entity.dictionary;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

/**
 * [费用类别字典表--category]
 *
 * @Author create by
 * @date 2020/7/4-9:46
 */
@Data
@TableName("category")
public class Category extends BaseEntity implements Serializable {

	/**
	 * 费用类别id
	 */
	@ApiModelProperty(value = "费用类别id")
	private Long categoryId;
	/**
	 * 费用类别名称
	 */
	@ApiModelProperty(value = "费用类别名称")
	private String text;
}


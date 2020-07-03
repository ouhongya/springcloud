package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springblade.core.tenant.mp.TenantEntity;

import java.io.Serializable;


@Data
@TableName("request_charge_info")
public class ItemCount extends TenantEntity implements Serializable {


	private static final long serialVersionUID = 1897326014230091879L;

	//收费项目id
	private int item_id;

	//项目类别id
	private int item_type_id;

	//数量
	private int item_count;

	//申请单id
	private long request_id;
}



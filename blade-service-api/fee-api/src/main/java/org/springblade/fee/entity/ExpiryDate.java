package org.springblade.fee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("expiry_date")
public class ExpiryDate implements Serializable {


	private static final long serialVersionUID = 6784351522947932841L;

	//有效期主键
	private int id;

	//项目有效期天数，过期作废
	private int valid_quantum;

}




package org.springblade.fee.entity;


import lombok.Data;
import java.io.Serializable;



@Data
public class RecordChargeRequest  implements Serializable {


	private static final long serialVersionUID = 3619363860814425266L;


	//token
	private String token;

	//secret
	private String secret;


	RecordCharge recordCharge;

}




package org.springblade.fee.vo;

import lombok.Data;

@Data
public class PatientBriefData {

	//患者ID
	private long id;

	//患者姓名
	private String name;

	//性别
	private String sex;

	//出生日期
	private String birth;

	//年龄-按照出生日期计算。不足岁的，年龄单位为月 不足月的，年龄单位为天 示例“32岁”
	private String age;

	//民族
	private String ethnicity;

	//联系方式
	private String contact;


}

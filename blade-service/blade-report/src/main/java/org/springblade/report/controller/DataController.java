package org.springblade.report.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("api")
public class DataController {
	//科室数据
 private static  Map<Integer, String> deptData  = new HashMap<>();
 ////医生
 private static  Map<Integer, String> octorData  = new HashMap<>();
 //药品
 private static  Map<Integer, DrugChargeBrief> drugData  = new HashMap<>();
 //患者
 private static  Map<Integer, PatientBriefData> patientData  = new HashMap<>();
 //医生
 private static  List< StaffInfo> staffInfoData  = new ArrayList<>();
 //科室
 private static  List< dept> deptDatas  = new ArrayList<>();
	//患者信息检索
 private static PatientBrief patientBrief = new PatientBrief(1l, "lucy", "0101010101010101");
 {
	 //科室
		deptData.put(1, "门诊");
		deptData.put(2, "放射科");
		deptData.put(3, "口腔");
		deptData.put(4, "五官");
		deptData.put(5, "急诊");
		//科室
		deptDatas.add(new dept("门诊", 1));
		deptDatas.add(new dept("放射科", 2));
		deptDatas.add(new dept("口腔", 3));
		deptDatas.add(new dept("五官", 4));
		deptDatas.add(new dept("急诊", 5));
	 //医生
		octorData.put(1, "张三");
		octorData.put(2, "李四");
		octorData.put(3, "王超");
		octorData.put(4, "马汉");
		octorData.put(5, "张龙");
	 //药品
	 drugData.put(0, new DrugChargeBrief(0,1,new BigDecimal("20.0000"),"阿莫西林","6mg:200ug*24","盒","成都科伦药业"));
		drugData.put(1, new DrugChargeBrief(1,2,new BigDecimal("50.0000"),"江中健胃消食片","6mg:200ug*24","盒","成都科伦药业"));
		drugData.put(2, new DrugChargeBrief(2,3,new BigDecimal("1000.0000"),"牛黄解毒片","6mg:200ug*24","盒","成都科伦药业"));
		drugData.put(3, new DrugChargeBrief(3,2,new BigDecimal("66.6667"),"青霉素","6mg:200ug*24","盒","成都科伦药业"));
		drugData.put(4, new DrugChargeBrief(4,5,new BigDecimal("200.0000"),"西瓜霜","6mg:200ug*24","盒","成都科伦药业"));
		drugData.put(5, new DrugChargeBrief(5,4,new BigDecimal("6000.0000"),"创可贴","6mg:200ug*24","盒","成都科伦药业"));

	 //患者
		patientData.put(1, new PatientBriefData(1,"lucy","女","2020-02-01","12",null,null));
		//医生
		staffInfoData.add( new StaffInfo(1, "张三", 1, 0, 0));
		staffInfoData.add( new StaffInfo(2, "李四", 2, 0, 0));
		staffInfoData.add( new StaffInfo(3, "王超", 3, 0, 0));
		staffInfoData.add(new StaffInfo(4, "马汉", 4, 0, 0));
		staffInfoData.add( new StaffInfo(5, "张龙", 1, 0, 0));

 }
 /**
  * 科室
  * @param id
  * @return
  */
 @RequestMapping("/getDepts")
 public List< dept> getDepts() {

	 return deptDatas;
 }
	/**
	 * 科室
	 * @param id
	 * @return
	 */
	@RequestMapping("/getDeptName")
	public String getDeptName(@RequestParam("dept_id")int id) {

		System.out.println("id="+id);
		return deptData.get(id);
	}

	/**
	 *    医生
	 * @param id
	 * @return
	 */
	@RequestMapping("/getDoctorName")
	public String getDoctorName(@RequestParam("doctor_id")int id) {

		System.out.println("id="+id);
		return octorData.get(id);
	}
	/**
	 医生
	 * @param id
	 * @return
	 */
	@RequestMapping("/getDoctorAllName")
	public List< StaffInfo> getDoctorAllName() {

		return staffInfoData;
	}
	/**
	 *         药品
	 * @param id
	 * @return
	 */
	@RequestMapping("/getDrugChargeBrief")
	public DrugChargeBrief getDrugChargeBrief(@RequestParam("drug_id")int id) {

		System.out.println("id="+id);
		return drugData.get(id);
	}
	/**
	 *         患者
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getPatientBriefData")
	public PatientBriefData getPatientData(@RequestParam("id")int id) {

		System.out.println("id="+id);
		return patientData.get(id);
	}
	/**
	 * 患者
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getPatientBriefID")
	public long getPatientDataID(PatientBrief pa) {
		System.out.println(pa);
		System.out.println(patientBrief);
		return patientBrief.getId();
	}


}


@Data
@AllArgsConstructor
/**
 * 访问用户信息
 */
class dept {


    //科室名
    private String name;

    //用户科室id
    private int dept_id;

}
@Data
@AllArgsConstructor
/**
 * 访问用户信息
 */
class StaffInfo {
    //用户id
    private int staff_id;

    //用户名
    private String name;

    //用户科室id
    private int dept_id;

    //用户医院id
    private int hospital_id;

    //用户角色id
    private int role_id;
}
@Data
@AllArgsConstructor
class DrugChargeBrief {
    //药品id
    private int drug_id;

    //药品类别
    private int drug_type_id;

    //药品费用
    private BigDecimal fee;

    //药品名称
    private String name;

    //药品规格
    private String spec;

    //药品单位
    private String unit;

    //药品生产厂商
    private String producer;
}
@Data
@AllArgsConstructor
/**
 * 患者信息提要
 */
class PatientBriefData {
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
@Data
@AllArgsConstructor
/**
 * 患者信息提要
 */
class PatientBrief {
    //患者ID
    private Long id;

    //患者姓名
    private String name;

    //身份证号
    private String numberID;

}

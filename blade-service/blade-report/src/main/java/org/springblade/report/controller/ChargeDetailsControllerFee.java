package org.springblade.report.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springblade.core.tool.api.R;
import org.springblade.report.entity.RequestDetailReceiptVo;
import org.springblade.report.service.ChargeDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Api(value = "费用明细", tags = "费用明细")
@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ChargeDetailsControllerFee {

	private ChargeDetailsService chargeDetailsService;

	@GetMapping("/queryChargeDetailsList")
	@ApiOperation(value = "费用明细查询", notes = "费用明细查询")
	public R queryChargeDetailsList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryChargeDetailsList(requestDetailReceiptVo));
	}

	@GetMapping("/queryHospitalizedList")
	@ApiOperation(value = "住院预交金查询", notes = "住院预交金查询")
	public R queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryHospitalizedList(requestDetailReceiptVo));
	}

	@GetMapping("/queryInvoiceList")
	@ApiOperation(value = "发票列表", notes = "发票列表")
	public R queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo) {
		return R.data(chargeDetailsService.queryInvoiceList(requestDetailReceiptVo));
	}

	@GetMapping("/getChargeDetailsList")
	public ChargeDetailsList getChargeDetailsList(String id){
		ChargeDetailsList detailsList = new ChargeDetailsList();
		detailsList.setName("江中牌健胃消食片");
		detailsList.setBilling("儿科");
		detailsList.setCarried("暂无");
		detailsList.setUnit("盒");
		return detailsList;
	}

	@GetMapping("/queryHospitalizedList1")
	public queryHospitalizedList1 queryHospitalizedList1(String id){
		queryHospitalizedList1 queryHospitalizedList = new queryHospitalizedList1();
		queryHospitalizedList.setName("这是一个科室");
		queryHospitalizedList.setDocker("这是一个医生");
		return queryHospitalizedList;
	}

	@GetMapping("/queryInvoiceList1")
	public queryInvoiceList1 queryInvoiceList1(String id){
		queryInvoiceList1 c = new queryInvoiceList1();
		c.setName("这是一个名字");
		c.setDockName("这是一个医生");
		return c;
	}

	@GetMapping("/refund")
	public List<rfundMoney> refund(){
		List<rfundMoney> r = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			rfundMoney rr = new rfundMoney();
			rr.setId("1234568321"+i);
			rr.setItemId("5145448123"+i);
			rr.setName("小葵花妈妈课堂开课了"+i);
			rr.setSpecification("6mg:200ug*24");
			rr.setPrice("10.2"+i);
			rr.setUnit("盒");
			rr.setJijia("250.00");
			if(i%2==0){
				rr.setPayMoney("250.00");
			}else{
				rr.setPayMoney("150.00");
			}
			if(i%2==0){
				rr.setRefund("没钱买药,不敢感冒");
			}
			if(i%2==0){
				rr.setMoney("250.00");
			}else{
				rr.setMoney("150.00");
			}
			r.add(rr);
		}
		return r;
	}

	@GetMapping("/receipt")
	public receipt a (){
		receipt r = new receipt();
		r.setName("小葵花妈妈课堂开课了!");
		r.setSpecification("6mg:200ug*24");
		r.setCarried("暂无");
		r.setNegative("门诊");
		return r;
	}

}
@Data
class receipt{
	private String name;
	private String specification;
	private String negative;
	private String carried;
}
@Data
class rfundMoney{
	private String id;
	private String itemId;
	private String name;
	private String specification;
	private String price;
	private String num;
	private String unit;
	private String jijia;
	private String payMoney;
	private String refund;
	private String money;
}
@Data
class ChargeDetailsList{
	//项目名
	private String name;
	//开单科室
	private String billing;
	//执行科室
	private String carried;
	//单位
	private String unit;
}

@Data
class queryHospitalizedList1{
	private String name;
	private String docker;
}

@Data
class queryInvoiceList1{
	private String dockName;
	private String name;
}

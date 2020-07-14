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
		detailsList.setBilling("挂科?");
		detailsList.setCarried("飞科?");
		detailsList.setUnit("盒");
		return detailsList;
	}

	@GetMapping("/queryHospitalizedList1")
	public queryHospitalizedList1 queryHospitalizedList1(String id){
		queryHospitalizedList1 queryHospitalizedList = new queryHospitalizedList1();
		queryHospitalizedList.setName("嘿哈");
		queryHospitalizedList.setDocker("钟南山");
		return queryHospitalizedList;
	}

	@GetMapping("/queryInvoiceList1")
	public queryInvoiceList1 queryInvoiceList1(String id){
		queryInvoiceList1 c = new queryInvoiceList1();
		c.setName("王德发");
		c.setDockName("陈稻");
		return c;
	}

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

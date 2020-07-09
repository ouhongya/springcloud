package org.springblade.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.springblade.report.entity.ChargeReceipt;
import org.springblade.report.entity.RequestDetailReceiptVo;


public interface ChargeDetailsService extends IService<ChargeReceipt> {

	PageInfo queryChargeDetailsList(RequestDetailReceiptVo requestDetailReceiptVo);

	PageInfo queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo);

	PageInfo queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo);
}

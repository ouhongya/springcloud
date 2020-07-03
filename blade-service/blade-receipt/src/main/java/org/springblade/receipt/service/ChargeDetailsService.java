package org.springblade.receipt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.springblade.receipt.entity.*;

import java.util.List;

public interface ChargeDetailsService extends IService<ChargeReceipt> {

	PageInfo queryRequestDetailReceipt(RequestDetailReceiptVo requestDetailReceiptVo);

	PageInfo queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo);

	PageInfo queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo);
}

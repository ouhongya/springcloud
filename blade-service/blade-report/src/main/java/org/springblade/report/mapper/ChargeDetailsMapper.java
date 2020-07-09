package org.springblade.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.report.entity.*;

import java.util.List;

public interface ChargeDetailsMapper extends BaseMapper<ChargeReceipt> {

	List<RequestDetailsReceiptRes>  queryRequestDetailReceipt(RequestDetailReceiptVo requestDetailReceiptVo);

	List<HospitalizedVo>  queryHospitalizedList(RequestDetailReceiptVo requestDetailReceiptVo);

	List<InvoiceVo> queryInvoiceList(RequestDetailReceiptVo requestDetailReceiptVo);
}

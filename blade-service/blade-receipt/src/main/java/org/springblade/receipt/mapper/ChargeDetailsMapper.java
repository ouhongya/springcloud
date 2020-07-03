package org.springblade.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.receipt.entity.ChargeReceipt;
import org.springblade.receipt.entity.RequestDetailReceiptVo;
import org.springblade.receipt.entity.RequestDetailsReceiptRes;

import java.util.List;

public interface ChargeDetailsMapper extends BaseMapper<ChargeReceipt> {

	List<RequestDetailsReceiptRes>  queryRequestDetailReceipt(RequestDetailReceiptVo requestDetailReceiptVo);
}

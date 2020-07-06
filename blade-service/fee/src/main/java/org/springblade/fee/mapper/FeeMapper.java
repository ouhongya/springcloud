package org.springblade.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.fee.entity.ChargeRequest;
import org.springblade.fee.entity.ItemCount;
import org.springblade.fee.entity.RecordCharge;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.vo.DicRequestType;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.Feedetail;
import org.springblade.fee.vo.ItemFavor;

import java.util.List;


public interface FeeMapper extends BaseMapper<RequestChargeInfo> {

	List<Fee> selectFeeList(List<Long> request_id_list);

	RequestChargeInfo selectRequestChargeInfo(Long request_id);

	List<Feedetail> selectFeeDetail(Long request_id);

	int insertItemCount(ItemCount itemCount);

	int insertRequestChargeInfo(RequestChargeInfo requestChargeInfo);

	int updateItemCount(ItemCount itemCount);

	int updateItemCountByStatus(ItemCount itemCount);

	int updateItemCountItemFavor(ItemFavor itemFavor);

	int updateRequestChargeInfo(RequestChargeInfo requestChargeInfo);

	int deleteItemCount(Long request_id);

	int deleteRequestChargeInfo(Long request_id);

	int insertChargeRequest(ChargeRequest chargeRequest);

	int updateChargeRequest(ChargeRequest chargeRequest);

	int updateChargeRequestByChargeId(ChargeRequest chargeRequest);


	int deleteChargeRequest(Long request_id);

	ChargeRequest selectChargeRequest(Long request_id);

	DicRequestType selectDicRequestType(Integer id);

	int insertRecordCharge(RecordCharge recordCharge);

	RecordCharge selectRecordCharge(Long id);

	int updateRecordCharge(RecordCharge recordCharge);

	List<ChargeRequest> selectChargeRequestList(Long charge_id);

	ItemCount selectItemCount(ItemCount itemCount);


}



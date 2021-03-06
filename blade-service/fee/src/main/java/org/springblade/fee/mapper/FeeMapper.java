package org.springblade.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.springblade.fee.entity.*;
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

	int updateRecordChargeByStatus(RecordCharge recordCharge);

	List<ChargeRequest> selectChargeRequestList(Long charge_id);

	ItemCount selectItemCount(ItemCount itemCount);

	String selectItemCountByFEEITEM(ItemFavor itemFavor);

	int insertChargePay(ChargePay chargePay);

	int updateChargePay(ChargePay chargePay);

	List<Integer> selectExpiryDate();

	int updateRecordChargeByCreateTime(Integer i);

	List<RecordCharge> querycharge(RecordCharge recordCharge);
}



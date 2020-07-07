package org.springblade.fee.service;



import org.springblade.core.mp.base.BaseService;
import org.springblade.fee.entity.ItemCount;
import org.springblade.fee.entity.RecordChargeRequest;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.vo.Favourable;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.FeeRequest;
import org.springblade.fee.vo.Feedetail;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface FeeService extends BaseService<RequestChargeInfo> {


	List<Fee>  queryapplicationfrom(List<Long> request_id_list);

	List<Feedetail> queryapplication(Long request_id);

	Map<Long,List<Feedetail>> querychargefeedetail(Long charge_id);

	boolean submit(RequestChargeInfo requestChargeInfo);

	Long submitrecordcharge(RecordChargeRequest recordChargeRequest);

	boolean updateApplicationfrom(RequestChargeInfo requestChargeInfo);

	boolean removeApplicationfrom(List<Long> request_id_list);

	Favourable createfavourable(Double money, String reason, Long id);

	boolean updateRequestChargeInfo(ItemCount itemCount);

	String getPagePay(Long charge_id, BigDecimal fee_paid,List<FeeRequest> feeRequest,Integer checked);

	String wxpay(Long charge_id, BigDecimal fee_paid,List<FeeRequest> feeRequest,Integer checked);

	String moneypay(Long charge_id, List<FeeRequest> feeRequest, BigDecimal fee_paid,Integer checked,Integer channel_id);


}

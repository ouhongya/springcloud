package org.springblade.fee.service;



import org.springblade.core.mp.base.BaseService;
import org.springblade.fee.entity.RecordChargeRequest;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.Feedetail;

import java.util.List;

public interface FeeService extends BaseService<RequestChargeInfo> {


	List<Fee>  queryapplicationfrom(List<Long> request_id_list);

	List<Feedetail> queryapplication(Long request_id);

	boolean submit(RequestChargeInfo requestChargeInfo);

	Long submitrecordcharge(RecordChargeRequest recordChargeRequest);

	boolean updateApplicationfrom(RequestChargeInfo requestChargeInfo);

	boolean removeApplicationfrom(List<Long> request_id_list);


}

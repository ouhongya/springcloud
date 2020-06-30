package org.springblade.fee.service;


import org.springblade.core.launch.constant.AppConstant;
import org.springblade.core.mp.base.BaseService;
import org.springblade.fee.entity.Applicationfrom;
import org.springblade.fee.vo.Fee;
import org.springblade.fee.vo.PatientBriefData;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
public interface FeeService extends BaseService<Applicationfrom> {

	PatientBriefData queryPatientBriefData(Long  patient_id);
	List<Fee>  queryapplicationfrom(List<Long> request_id_list);

}

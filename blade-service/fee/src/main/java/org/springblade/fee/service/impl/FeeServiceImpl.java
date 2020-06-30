package org.springblade.fee.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springblade.common.utils.CommonUtil;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.fee.entity.Applicationfrom;
import org.springblade.fee.feign.IFeeClient;
import org.springblade.fee.mapper.FeeMapper;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeeServiceImpl extends BaseServiceImpl<FeeMapper, Applicationfrom> implements FeeService {


	private IFeeClient iFeeClient;

	/**
	 * 获取患者信息接口
	 */
	@Override
	public PatientBriefData queryPatientBriefData( Long patient_id) {
		String url = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("patient_id", patient_id);
		String res = CommonUtil.doGet(url, map);
		PatientBriefData patientbriefdata = JSONObject.parseObject(res, PatientBriefData.class);
		return patientbriefdata;
	}

	/**
	 * 获取申请单列表
	 */
	@Override
	public List<Fee> queryapplicationfrom(List<Long> request_id_list) {

		List<Fee> fees = baseMapper.selectFeeList(request_id_list);
		for(Fee fee:fees){
			int requestType = fee.getRequestType();
			DicRequestType dicRequestType =new DicRequestType();
			dicRequestType.setId(requestType);
			DicRequestType dicrequesttype = baseMapper.selectDicRequestTypeById(dicRequestType);
			String text = dicrequesttype.getText();
			int deptId = fee.getDeptId();
			int doctorId = fee.getDoctorId();
			String urldeptId = "";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dept_id", deptId);
			String res = CommonUtil.doGet(urldeptId, map);
			Dept dept = JSONObject.parseObject(res, Dept.class);
			String urldoctorId = "";
			Map<String, Object> mapdoctor = new HashMap<String, Object>();
			mapdoctor.put("staff_id", doctorId);
			String resdoctor = CommonUtil.doGet(urldoctorId, mapdoctor);
			StaffInfo staffinfo = JSONObject.parseObject(resdoctor, StaffInfo.class);
			int itemId = fee.getItemId();
			String urlitemId = "";
			Map<String, Object> mapitem = new HashMap<String, Object>();
			mapitem.put("item_id", itemId);
			String resitem = CommonUtil.doGet(urlitemId, mapitem);
			ItemChargeBrief itemchargebrief = JSONObject.parseObject(resitem, ItemChargeBrief.class);
			int item_type_id = itemchargebrief.getItem_type_id();

			String urlitemtypeid= "";
			Map<String, Object> mapitemtype = new HashMap<String, Object>();
			mapitemtype.put("item_type_id", item_type_id);
			String resitemtype = CommonUtil.doGet(urlitemtypeid, mapitemtype);
//			ItemChargeBrief itemchargebrief = JSONObject.parseObject(resitemtype, ItemChargeBrief.class);



		}


		return fees;


	}

}

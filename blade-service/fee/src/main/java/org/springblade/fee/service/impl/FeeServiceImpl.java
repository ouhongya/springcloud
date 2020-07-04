package org.springblade.fee.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.core.tool.api.R;
import org.springblade.fee.entity.*;
import org.springblade.fee.feign.IFeeClient;
import org.springblade.fee.mapper.FeeMapper;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;


@Service
public class FeeServiceImpl extends BaseServiceImpl<FeeMapper, RequestChargeInfo> implements FeeService {


	@Autowired
	private RedisTemplate redisTemplate;

//	@Autowired
	private IFeeClient iFeeClient;




	/**
	 *  获取申请单列表
	 */
	@Override
	public List<Fee> queryapplicationfrom(List<Long> request_id_list) {

		//申请单列表
		List<Fee> fees = baseMapper.selectFeeList(request_id_list);

		//申请单详情
		for(Fee fee:fees){
			String RequestType = (String) redisTemplate.boundValueOps(String.valueOf(fee.getRequestId())).get();
			fee.setRequestType(RequestType);
		}
		return fees;
	}

	/**
	 * 获取项目明细
	 * @param request_id
	 * @return
	 */

	@Override
	public List<Feedetail> queryapplication(Long request_id) {
		List<Feedetail> feedetail = baseMapper.selectFeeDetail(request_id);
		ChargeRequest chargeRequest = baseMapper.selectChargeRequest(request_id);
		for(Feedetail feedtail:feedetail){
			feedtail.setDept_id(chargeRequest.getDept_id());
		}
		return  feedetail;
	}

	/**
	 * 收费列表
	 */

	@Override
	public Map<Long,List<Feedetail>> querychargefeedetail(Long charge_id) {
		List<ChargeRequest> chargeRequests = baseMapper.selectChargeRequestList(charge_id);
		Map<Long,List<Feedetail>> result=new HashMap<>();
		for(ChargeRequest chargeRequest:chargeRequests){
			long request_id = chargeRequest.getRequest_id();
			List<Feedetail> feedetails = baseMapper.selectFeeDetail(request_id);
			result.put(request_id,feedetails);
		}
		return result;
	}

	/**
	 * 新增申请单
	 * @param
	 * @return
	 */

	@Override
	public boolean submit(RequestChargeInfo requestChargeInfo) {
		try{
			long patient_id=requestChargeInfo.getPatient_id();
			List<Integer> item_ids=new ArrayList<>();
			List<ItemCount> item_list = requestChargeInfo.getItem_list();
			for(ItemCount itemCount:item_list){
				itemCount.setRequest_id(requestChargeInfo.getRequest_id());
				item_ids.add(itemCount.getItem_id());
				baseMapper.insertItemCount(itemCount);
			}
			Integer[] itemids = new Integer[item_ids.size()];
			item_ids.toArray(itemids);
			R<FavorItemBrief> favorItemBriefR = iFeeClient.item_favor(patient_id, itemids);
			FavorItemBrief data = favorItemBriefR.getData();
			List<ItemFavor> favor_list = data.getFavor_list();
			for(ItemFavor itemFavor:favor_list){
				baseMapper.updateItemCountItemFavor(itemFavor);
			}
			baseMapper.insertRequestChargeInfo(requestChargeInfo);
			Claims claims;
			try {
				claims = Jwts.parser()
					.setSigningKey(requestChargeInfo.getSecret())
					.parseClaimsJws(requestChargeInfo.getToken())
					.getBody();
			} catch (Exception e) {
				claims = null;
			}
			int dept_id =Integer.valueOf(claims.get("Dept_id").toString());
			int Doctor_id =Integer.valueOf(claims.get("Doctor_id").toString());
			ChargeRequest chargeRequest=new ChargeRequest();
			chargeRequest.setDoctor_id(Doctor_id);
			chargeRequest.setDept_id(dept_id);
			chargeRequest.setRequest_id(requestChargeInfo.getRequest_id());
			chargeRequest.setPatient_id(requestChargeInfo.getPatient_id());
			chargeRequest.setRequest_type(requestChargeInfo.getRequest_type_id());
			baseMapper.insertChargeRequest(chargeRequest);
			DicRequestType dicRequestype = baseMapper.selectDicRequestType(requestChargeInfo.getRequest_type_id());
			redisTemplate.opsForValue().set(String.valueOf(requestChargeInfo.getRequest_id()),dicRequestype.getText());
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 新增收费记录
	 * @param
	 * @return
	 */

	@Override
	public Long submitrecordcharge(RecordChargeRequest recordChargeRequest) {
		try{
			Claims claims;
			try {
				claims = Jwts.parser()
					.setSigningKey(recordChargeRequest.getSecret())
					.parseClaimsJws(recordChargeRequest.getToken())
					.getBody();
			} catch (Exception e) {
				claims = null;
			}
			Long id = Long.valueOf(claims.get("ID").toString());
			int dept_id =Integer.valueOf(claims.get("Dept_id").toString());
			int Doctor_id =Integer.valueOf(claims.get("Doctor_id").toString());
			RecordCharge recordCharge = recordChargeRequest.getRecordCharge();
			recordCharge.setToll_collector_id(id);
			recordCharge.setCreate_time(new Date());
			long patient_id = recordCharge.getPatient_id();
			R<FavorPatientBrief> favorPatientBriefR = iFeeClient.patient_favor(patient_id);
			FavorPatientBrief data = favorPatientBriefR.getData();
			recordCharge.setFavor_channel_id(data.getFavor_id());
			recordCharge.setFavor_channel(data.getFavor_name());
			recordCharge.setFavor_fee(new BigDecimal(data.getFee_favor()));
            baseMapper.insertRecordCharge(recordCharge);
			List<Long> request_id_list = recordCharge.getRequest_id_list();
            for(Long request_id:request_id_list){
				ChargeRequest chargeRequest=new ChargeRequest();
				chargeRequest.setDoctor_id(Doctor_id);
				chargeRequest.setDept_id(dept_id);
				chargeRequest.setRequest_id(request_id);
				chargeRequest.setPatient_id(recordCharge.getPatient_id());
				RequestChargeInfo requestChargeInfo = baseMapper.selectRequestChargeInfo(request_id);
				chargeRequest.setRequest_type(requestChargeInfo.getRequest_type_id());
				chargeRequest.setCharge_id(recordCharge.getId());
				baseMapper.updateChargeRequest(chargeRequest);
			}

			return recordCharge.getId();
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 修改申请单
	 * @param
	 * @return
	 */

	@Override
	public boolean updateApplicationfrom(RequestChargeInfo requestChargeInfo) {
		try{
			List<ItemCount> item_list = requestChargeInfo.getItem_list();
			for(ItemCount itemCount:item_list){
				itemCount.setRequest_id(requestChargeInfo.getRequest_id());
				baseMapper.updateItemCount(itemCount);
			}
			baseMapper.updateRequestChargeInfo(requestChargeInfo);
			Claims claims;
			try {
				claims = Jwts.parser()
					.setSigningKey(requestChargeInfo.getSecret())
					.parseClaimsJws(requestChargeInfo.getToken())
					.getBody();
			} catch (Exception e) {
				claims = null;
			}
			int dept_id =Integer.valueOf(claims.get("Dept_id").toString());
			int Doctor_id =Integer.valueOf(claims.get("Doctor_id").toString());
			ChargeRequest chargeRequest=new ChargeRequest();
			chargeRequest.setDoctor_id(Doctor_id);
			chargeRequest.setDept_id(dept_id);
			chargeRequest.setRequest_id(requestChargeInfo.getRequest_id());
			chargeRequest.setPatient_id(requestChargeInfo.getPatient_id());
			chargeRequest.setRequest_type(requestChargeInfo.getRequest_type_id());
			baseMapper.updateChargeRequest(chargeRequest);
			DicRequestType dicRequestType = baseMapper.selectDicRequestType(requestChargeInfo.getRequest_type_id());
			redisTemplate.opsForValue().set(String.valueOf(requestChargeInfo.getRequest_id()),dicRequestType.getText());
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 删除申请单
	 * @param
	 * @return
	 */


	@Override
	public boolean removeApplicationfrom(List<Long> request_id_list) {

		try{
			for(long request_id:request_id_list){
				baseMapper.deleteItemCount(request_id);
				baseMapper.deleteRequestChargeInfo(request_id);
				baseMapper.deleteChargeRequest(request_id);
				redisTemplate.delete(String.valueOf(request_id));
			}
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}

}

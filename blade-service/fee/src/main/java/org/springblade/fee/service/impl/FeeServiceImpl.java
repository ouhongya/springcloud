package org.springblade.fee.service.impl;




import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.fee.entity.ChargeRequest;
import org.springblade.fee.entity.ItemCount;
import org.springblade.fee.entity.RequestChargeInfo;
import org.springblade.fee.mapper.FeeMapper;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class FeeServiceImpl extends BaseServiceImpl<FeeMapper, RequestChargeInfo> implements FeeService {


	@Autowired
	private RedisTemplate redisTemplate;


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
		return  feedetail;


	}

	/**
	 * 新增申请单
	 * @param
	 * @return
	 */

	@Override
	public boolean submit(RequestChargeInfo requestChargeInfo) {
		try{
			List<ItemCount> item_list = requestChargeInfo.getItem_list();
			for(ItemCount itemCount:item_list){
				itemCount.setRequest_id(requestChargeInfo.getRequest_id());
				baseMapper.insertItemCount(itemCount);
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
			chargeRequest.setRequest_type_id(requestChargeInfo.getRequest_type_id());
			baseMapper.insertChargeRequest(chargeRequest);
			DicRequestType dicRequestType = baseMapper.selectDicRequestType(requestChargeInfo.getRequest_type_id());
			redisTemplate.opsForValue().set(String.valueOf(requestChargeInfo.getRequest_id()),dicRequestType.getText());
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
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
			chargeRequest.setRequest_type_id(requestChargeInfo.getRequest_type_id());
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

package org.springblade.fee.service.impl;

import com.alibaba.csp.sentinel.util.IdUtil;
import com.github.wxpay.sdk.WXPay;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.core.tool.api.R;
import org.springblade.fee.config.WXPayConfigImpl;
import org.springblade.fee.entity.*;
import org.springblade.fee.feign.IFeeClient;
import org.springblade.fee.mapper.FeeMapper;
import org.springblade.fee.service.AlipayService;
import org.springblade.fee.service.FeeService;
import org.springblade.fee.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.util.*;


@Service
public class FeeServiceImpl extends BaseServiceImpl<FeeMapper, RequestChargeInfo> implements FeeService {


	@Autowired
	private RedisTemplate redisTemplate;

	//	@Autowired
	private IFeeClient iFeeClient;

	@Autowired
	private AlipayService alipayService;


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
				itemCount.setStatus(0);
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
			ChargeRequest chargeRequest=new ChargeRequest();
			chargeRequest.setDoctor_id(requestChargeInfo.getDoctor_id());
			chargeRequest.setDept_id(requestChargeInfo.getDept_id());
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
			Long id = Long.valueOf(claims.get("id").toString());
			RecordCharge recordCharge = recordChargeRequest.getRecordCharge();
			recordCharge.setToll_collector_id(id);
			recordCharge.setStatus(0);
			recordCharge.setCreate_time(new Date());
			baseMapper.insertRecordCharge(recordCharge);
			List<Long> request_id_list = recordCharge.getRequest_id_list();
			for(Long request_id:request_id_list){
				ChargeRequest chargeRequest=new ChargeRequest();
				chargeRequest.setRequest_id(request_id);
				chargeRequest.setCharge_id(recordCharge.getId());
				baseMapper.updateChargeRequestByChargeId(chargeRequest);
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
			int dept_id =Integer.valueOf(requestChargeInfo.getDept_id());
			int Doctor_id =Integer.valueOf(requestChargeInfo.getDoctor_id());
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

	@Override
	public Favourable createfavourable(Double money, String reason, Long id) {

		try{
			RecordCharge recordCharge=new RecordCharge();
			recordCharge.setId(id);
			recordCharge.setMoney(money);
			recordCharge.setReason(reason);
			int i = baseMapper.updateRecordCharge(recordCharge);
			Favourable favourable = new Favourable();
			favourable.setMoney(money);
			favourable.setReason(reason);
			return favourable;
		}catch (Exception e){
			e.printStackTrace();
			return new Favourable();
		}

	}

	@Override
	public boolean updateRequestChargeInfo(ItemCount itemCount) {
		ItemCount itemCount1 = baseMapper.selectItemCount(itemCount);
		Integer status = itemCount1.getStatus();
		if(status == 1){
			itemCount.setStatus(3);
			int i = baseMapper.updateItemCountByStatus(itemCount);
			return true;
		}
		return false;
	}

	@Override
	public String getPagePay(Long charge_id, BigDecimal fee_paid) {

		try {
			Long id=charge_id;
			RecordCharge recordCharge = baseMapper.selectRecordCharge(id);
			String md5 = DigestUtils.md5DigestAsHex(String.valueOf(recordCharge.getId()).getBytes());
			String outTradeNo = md5;
			String subject = String.valueOf(recordCharge.getId());
			String pay = alipayService.webPagePay(outTradeNo, fee_paid, subject);
			return pay;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String wxpay(Long charge_id, BigDecimal fee_paid) {
		Long id=charge_id;
		RecordCharge recordCharge = baseMapper.selectRecordCharge(id);
		String md5 = DigestUtils.md5DigestAsHex(String.valueOf(recordCharge.getId()).getBytes());
		WXPayConfigImpl config = null;
		WXPay wxpay = null;
		try {
			config = new WXPayConfigImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 异步通知地址
		String notifyUrl = config.getNotifyUrl();
		wxpay = new WXPay(config);
		Map<String, String> data = new HashMap<String, String>();
		// 商品描述
		data.put("body", recordCharge.getId().toString());
		// 商户订单号
		data.put("out_trade_no", md5);
		// 标价金额
		data.put("total_fee", String.valueOf((fee_paid.multiply(new BigDecimal(100))).intValue()));
		// 产品id
		data.put("product_id", recordCharge.getId().toString());
		// 终端IP:调用微信支付API的机器IP
		data.put("spbill_create_ip", "192.168.1.41");
		// 交易类型:此处指定为扫码支付
		data.put("trade_type", "NATIVE");
		// 异步通知 url
		data.put("notify_url", notifyUrl);
		// 自定义参数
		data.put("attach", recordCharge.getId().toString());
		Map<String, String> resp = null;
		try {
			resp = wxpay.unifiedOrder(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String codeUrl = resp.get("code_url");
		System.out.println("============= 微信返回结果 =============");
		System.out.println(resp);
		return codeUrl;

	}

	@Override
	public String moneypay(Long charge_id, List<FeeRequest> feeRequest, BigDecimal fee_paid) {
//		List<ChargeRequest> chargeRequests = baseMapper.selectChargeRequestList(charge_id);
//		List<FeeRequest> feeRequestother =new ArrayList<FeeRequest>();
//		for(ChargeRequest  chargeRequest:chargeRequests){
//			long request_id = chargeRequest.getRequest_id();
//			List<Integer> ids=new ArrayList<>();
//			List<Feedetail> feedetails = baseMapper.selectFeeDetail(request_id);
//			for(Feedetail feedetail:feedetails){
//				ids.add(feedetail.getItemId());
//			}
//			FeeRequest feerequest=new FeeRequest();
//			feerequest.setRequest_id(request_id);
//			feerequest.setItem_id(ids);
//			feeRequestother.add(feerequest);
//		}

		return null;
	}

}

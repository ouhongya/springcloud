package org.springblade.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.fee.entity.Applicationfrom;
import org.springblade.fee.vo.DicRequestType;
import org.springblade.fee.vo.Fee;

import java.util.List;


public interface FeeMapper extends BaseMapper<Applicationfrom> {

	List<Fee> selectFeeList(List<Long> request_id_list);
	DicRequestType selectDicRequestTypeById(DicRequestType dicrequesttype);
}

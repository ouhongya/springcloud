package org.springblade.report.mapper.dictionary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springblade.report.entity.dictionary.ExpiryDateVo;

import java.util.List;

/**
 * @Author create by
 * @date 2020/7/1-16:27
 */
public interface ExpiryDateMapper extends BaseMapper<ExpiryDateVo> {
	ExpiryDateVo selectByPrimaryKey(Integer id);


	List<ExpiryDateVo> selectAll();

	int updateByIds(@Param("validQuantum") Integer validQuantum);

	int add(ExpiryDateVo expiryDateVo);
}

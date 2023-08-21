package com.nuoquan.mapper.nq1;

import java.util.List;

import com.nuoquan.pojo.LotteryConfig;
import com.nuoquan.pojo.LotteryConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 奖品配置表 LotteryConfigMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-19 22:47:40
 */
@Repository
public interface LotteryConfigMapper {

    long countByExample(LotteryConfigExample example);

    int deleteByExample(LotteryConfigExample example);
	
    int deleteByPrimaryKey(Integer id);
	
    int insert(LotteryConfig record);

    int insertSelective(LotteryConfig record);

    List<LotteryConfig> selectByExample(LotteryConfigExample example);
	
    LotteryConfig selectByPrimaryKey(Integer id);
	
    int updateByExampleSelective(@Param("record") LotteryConfig record, @Param("example") LotteryConfigExample example);

    int updateByExample(@Param("record") LotteryConfig record, @Param("example") LotteryConfigExample example); 
	
    int updateByPrimaryKeySelective(LotteryConfig record);

    int updateByPrimaryKey(LotteryConfig record);
  	
}
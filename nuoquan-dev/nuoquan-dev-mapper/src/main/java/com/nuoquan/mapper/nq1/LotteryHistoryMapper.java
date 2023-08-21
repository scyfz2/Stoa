package com.nuoquan.mapper.nq1;

import java.util.List;

import com.nuoquan.pojo.LotteryHistory;
import com.nuoquan.pojo.LotteryHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 中奖记录表 LotteryHistoryMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-20 01:31:23
 */
@Repository
public interface LotteryHistoryMapper {

    long countByExample(LotteryHistoryExample example);

    int deleteByExample(LotteryHistoryExample example);
	
    int deleteByPrimaryKey(Integer id);
	
    int insert(LotteryHistory record);

    int insertSelective(LotteryHistory record);

    List<LotteryHistory> selectByExample(LotteryHistoryExample example);
	
    LotteryHistory selectByPrimaryKey(Integer id);
	
    int updateByExampleSelective(@Param("record") LotteryHistory record, @Param("example") LotteryHistoryExample example);

    int updateByExample(@Param("record") LotteryHistory record, @Param("example") LotteryHistoryExample example); 
	
    int updateByPrimaryKeySelective(LotteryHistory record);

    int updateByPrimaryKey(LotteryHistory record);
  	
}
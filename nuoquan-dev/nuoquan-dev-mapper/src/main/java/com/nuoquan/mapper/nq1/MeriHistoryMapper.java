package com.nuoquan.mapper.nq1;

import java.util.List;

import com.nuoquan.pojo.MeriHistory;
import com.nuoquan.pojo.MeriHistoryExample;
import org.apache.ibatis.annotations.Param;


/**
 * 功德领取记录表 MerihistoryMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-21 20:30:04
 */
public interface MeriHistoryMapper {

    long countByExample(MeriHistoryExample example);

    int deleteByExample(MeriHistoryExample example);
	
    int deleteByPrimaryKey(Integer id);
	
    int insert(MeriHistory record);

    int insertSelective(MeriHistory record);

    List<MeriHistory> selectByExample(MeriHistoryExample example);
	
    MeriHistory selectByPrimaryKey(Integer id);
	
    int updateByExampleSelective(@Param("record") MeriHistory record, @Param("example") MeriHistoryExample example);

    int updateByExample(@Param("record") MeriHistory record, @Param("example") MeriHistoryExample example); 
	
    int updateByPrimaryKeySelective(MeriHistory record);

    int updateByPrimaryKey(MeriHistory record);
  	
}
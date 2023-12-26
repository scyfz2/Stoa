package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.LeaderBoardObject;
import com.nuoquan.pojo.LeaderBoardObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 排行榜主表 LeaderBoardObjectMapper
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:38
 */
public interface LeaderBoardObjectMapper {

    long countByExample(LeaderBoardObjectExample example);

    int deleteByExample(LeaderBoardObjectExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(LeaderBoardObject record);

    int insertSelective(LeaderBoardObject record);

    List<LeaderBoardObject> selectByExample(LeaderBoardObjectExample example);
	
    LeaderBoardObject selectByPrimaryKey(Long id);
	
    int updateByExampleSelective(@Param("record") LeaderBoardObject record, @Param("example") LeaderBoardObjectExample example);

    int updateByExample(@Param("record") LeaderBoardObject record, @Param("example") LeaderBoardObjectExample example); 
	
    int updateByPrimaryKeySelective(LeaderBoardObject record);

    int updateByPrimaryKey(LeaderBoardObject record);
  	
}
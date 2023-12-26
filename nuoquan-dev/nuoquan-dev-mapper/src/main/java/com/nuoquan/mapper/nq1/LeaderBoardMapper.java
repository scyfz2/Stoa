package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.LeaderBoard;
import com.nuoquan.pojo.LeaderBoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 排行榜主表 LeaderBoardMapper
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:01:06
 */
public interface LeaderBoardMapper {

    long countByExample(LeaderBoardExample example);

    int deleteByExample(LeaderBoardExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(LeaderBoard record);

    int insertSelective(LeaderBoard record);

    List<LeaderBoard> selectByExample(LeaderBoardExample example);
	
    LeaderBoard selectByPrimaryKey(Long id);
	
    int updateByExampleSelective(@Param("record") LeaderBoard record, @Param("example") LeaderBoardExample example);

    int updateByExample(@Param("record") LeaderBoard record, @Param("example") LeaderBoardExample example); 
	
    int updateByPrimaryKeySelective(LeaderBoard record);

    int updateByPrimaryKey(LeaderBoard record);
  	
}
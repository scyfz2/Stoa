package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.LeaderBoardEvaluate;
import com.nuoquan.pojo.LeaderBoardEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 排行榜评论表 LeaderBoardEvaluateMapper
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:35
 */
public interface LeaderBoardEvaluateMapper {

    long countByExample(LeaderBoardEvaluateExample example);

    int deleteByExample(LeaderBoardEvaluateExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(LeaderBoardEvaluate record);

    int insertSelective(LeaderBoardEvaluate record);

    List<LeaderBoardEvaluate> selectByExample(LeaderBoardEvaluateExample example);
	
    LeaderBoardEvaluate selectByPrimaryKey(Long id);
	
    int updateByExampleSelective(@Param("record") LeaderBoardEvaluate record, @Param("example") LeaderBoardEvaluateExample example);

    int updateByExample(@Param("record") LeaderBoardEvaluate record, @Param("example") LeaderBoardEvaluateExample example); 
	
    int updateByPrimaryKeySelective(LeaderBoardEvaluate record);

    int updateByPrimaryKey(LeaderBoardEvaluate record);
  	
}
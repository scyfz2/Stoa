package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.LeaderBoardEvaluateStar;
import com.nuoquan.pojo.LeaderBoardEvaluateStarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 排行榜评论点亮表 LeaderBoardEvaluateStarMapper
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:37
 */
public interface LeaderBoardEvaluateStarMapper {

    long countByExample(LeaderBoardEvaluateStarExample example);

    int deleteByExample(LeaderBoardEvaluateStarExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(LeaderBoardEvaluateStar record);

    int insertSelective(LeaderBoardEvaluateStar record);

    List<LeaderBoardEvaluateStar> selectByExample(LeaderBoardEvaluateStarExample example);
	
    LeaderBoardEvaluateStar selectByPrimaryKey(Long id);
	
    int updateByExampleSelective(@Param("record") LeaderBoardEvaluateStar record, @Param("example") LeaderBoardEvaluateStarExample example);

    int updateByExample(@Param("record") LeaderBoardEvaluateStar record, @Param("example") LeaderBoardEvaluateStarExample example); 
	
    int updateByPrimaryKeySelective(LeaderBoardEvaluateStar record);

    int updateByPrimaryKey(LeaderBoardEvaluateStar record);
  	
}
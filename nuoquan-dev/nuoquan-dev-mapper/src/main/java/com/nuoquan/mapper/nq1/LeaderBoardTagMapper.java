package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.LeaderBoardTag;
import com.nuoquan.pojo.LeaderBoardTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 排行榜评论点亮表 LeaderBoardTagMapper
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:39
 */
public interface LeaderBoardTagMapper {

    long countByExample(LeaderBoardTagExample example);

    int deleteByExample(LeaderBoardTagExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(LeaderBoardTag record);

    int insertSelective(LeaderBoardTag record);

    List<LeaderBoardTag> selectByExample(LeaderBoardTagExample example);
	
    LeaderBoardTag selectByPrimaryKey(Long id);
	
    int updateByExampleSelective(@Param("record") LeaderBoardTag record, @Param("example") LeaderBoardTagExample example);

    int updateByExample(@Param("record") LeaderBoardTag record, @Param("example") LeaderBoardTagExample example); 
	
    int updateByPrimaryKeySelective(LeaderBoardTag record);

    int updateByPrimaryKey(LeaderBoardTag record);
  	
}
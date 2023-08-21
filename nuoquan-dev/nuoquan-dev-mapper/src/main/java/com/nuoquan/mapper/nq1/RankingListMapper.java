package com.nuoquan.mapper.nq1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.RankingListExample;

/**
 * 排行榜 RankingListMapper
 * 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-21 21:34:32
 */
public interface RankingListMapper {

    long countByExample(RankingListExample example);

    int deleteByExample(RankingListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RankingList record);

    int insertSelective(RankingList record);

    List<RankingList> selectByExample(RankingListExample example);

    RankingList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RankingList record, @Param("example") RankingListExample example);

    int updateByExample(@Param("record") RankingList record, @Param("example") RankingListExample example);

    int updateByPrimaryKeySelective(RankingList record);

    int updateByPrimaryKey(RankingList record);

}

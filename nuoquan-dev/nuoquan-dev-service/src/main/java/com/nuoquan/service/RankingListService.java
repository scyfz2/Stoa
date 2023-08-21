package com.nuoquan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.mapper.nq1.RankingListMapper;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.RankingListExample;
import com.nuoquan.pojo.admin.TableparV2;

import cn.hutool.core.util.StrUtil;

/**
 * 排行榜 RankingListService
 * 
 * @Title: RankingListService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-21 21:34:32  
 **/
@Service
public class RankingListService implements BaseService<RankingList, RankingListExample> {
    @Autowired
    private RankingListMapper rankingListMapper;

    /**
     * 分页查询
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<RankingList> list(TableparV2 tablepar, RankingList rankingList) {
        RankingListExample testExample = new RankingListExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
            testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
        } else {//大搜索
            testExample.createCriteria().andLikeQuery(rankingList);
        }
        //表格排序
        //if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
        //}else{
        //	testExample.setOrderByClause("id ASC");
        //}
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<RankingList> list = rankingListMapper.selectByExample(testExample);
        PageInfo<RankingList> pageInfo = new PageInfo<RankingList>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        return 0;

    }

    @Override
    public RankingList selectByPrimaryKey(String id) {

        Long id1 = Long.valueOf(id);
        return rankingListMapper.selectByPrimaryKey(id1);

    }

    @Override
    public int updateByPrimaryKeySelective(RankingList record) {
        return rankingListMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(RankingList record) {

        record.setId(null);

        return rankingListMapper.insertSelective(record);
    }

    @Override
    public int updateByExampleSelective(RankingList record, RankingListExample example) {

        return rankingListMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(RankingList record, RankingListExample example) {

        return rankingListMapper.updateByExample(record, example);
    }

    @Override
    public List<RankingList> selectByExample(RankingListExample example) {

        return rankingListMapper.selectByExample(example);
    }

    @Override
    public long countByExample(RankingListExample example) {

        return rankingListMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RankingListExample example) {

        return rankingListMapper.deleteByExample(example);
    }

    /**
     * 修改权限状态展示或者不展示
     * 
     * @param rankingList
     * @return
     */
    public int updateVisible(RankingList rankingList) {
        return rankingListMapper.updateByPrimaryKeySelective(rankingList);
    }

}

package com.nuoquan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.mapper.nq1.LotteryHistoryMapper;
import com.nuoquan.pojo.LotteryHistory;
import com.nuoquan.pojo.LotteryHistoryExample;
import com.nuoquan.pojo.admin.TableparV2;

import cn.hutool.core.util.StrUtil;

/**
 * 中奖记录表 LotteryHistoryService
 * 
 * @Title: LotteryHistoryService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-20 01:31:23  
 **/
@Service
public class LotteryHistoryService implements BaseService<LotteryHistory, LotteryHistoryExample> {
    @Autowired
    private LotteryHistoryMapper lotteryHistoryMapper;

    /**
     * 分页查询
     * 
     * @param tablepar
     * @param lotteryHistory
     * @return
     */
    public PageInfo<LotteryHistory> list(TableparV2 tablepar, LotteryHistory lotteryHistory) {
        LotteryHistoryExample testExample = new LotteryHistoryExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
            testExample.createCriteria().andUserIdLike("%" + tablepar.getSearchText() + "%");
        } else {//大搜索
            testExample.createCriteria().andLikeQuery(lotteryHistory);
        }
        //表格排序
        //if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
        //}else{
        //	testExample.setOrderByClause("id ASC");
        //}
        testExample.setOrderByClause("lottery_date desc");
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<LotteryHistory> list = lotteryHistoryMapper.selectByExample(testExample);
        PageInfo<LotteryHistory> pageInfo = new PageInfo<LotteryHistory>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {

        return 0;

    }

    @Override
    public LotteryHistory selectByPrimaryKey(String id) {

        Integer id1 = Integer.valueOf(id);
        return lotteryHistoryMapper.selectByPrimaryKey(id1);

    }

    @Override
    public int updateByPrimaryKeySelective(LotteryHistory record) {
        return lotteryHistoryMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(LotteryHistory record) {

        record.setId(null);

        return lotteryHistoryMapper.insertSelective(record);
    }

    @Override
    public int updateByExampleSelective(LotteryHistory record, LotteryHistoryExample example) {

        return lotteryHistoryMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(LotteryHistory record, LotteryHistoryExample example) {

        return lotteryHistoryMapper.updateByExample(record, example);
    }

    @Override
    public List<LotteryHistory> selectByExample(LotteryHistoryExample example) {

        return lotteryHistoryMapper.selectByExample(example);
    }

    @Override
    public long countByExample(LotteryHistoryExample example) {

        return lotteryHistoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LotteryHistoryExample example) {

        return lotteryHistoryMapper.deleteByExample(example);
    }

    /**
     * 修改权限状态展示或者不展示
     * 
     * @param lotteryHistory
     * @return
     */
    public int updateVisible(LotteryHistory lotteryHistory) {
        return lotteryHistoryMapper.updateByPrimaryKeySelective(lotteryHistory);
    }

}

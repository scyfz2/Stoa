package com.nuoquan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.mapper.nq1.MeriHistoryMapper;
import com.nuoquan.pojo.MeriHistory;
import com.nuoquan.pojo.MeriHistoryExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

import cn.hutool.core.util.StrUtil;

/**
 * 功德领取记录表 MeriHistoryService
 * 
 * @Title: MeriHistoryService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-21 20:46:05  
 **/
@Service
public class MeriHistoryService implements BaseService<MeriHistory, MeriHistoryExample> {
    @Autowired
    private MeriHistoryMapper meriHistoryMapper;

    /**
     * 分页查询
     * 
     * @param tablepar
     * @param meriHistory
     * @return
     */
    public PageInfo<MeriHistory> list(TableparV2 tablepar, MeriHistory meriHistory) {
        MeriHistoryExample testExample = new MeriHistoryExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
            testExample.createCriteria().andUserIdLike("%" + tablepar.getSearchText() + "%");
        } else {//大搜索
            testExample.createCriteria().andLikeQuery(meriHistory);
        }
        testExample.setOrderByClause("date DESC");
        //表格排序
        //if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
        //}else{
        //	testExample.setOrderByClause("id ASC");
        //}
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<MeriHistory> list = meriHistoryMapper.selectByExample(testExample);
        PageInfo<MeriHistory> pageInfo = new PageInfo<MeriHistory>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> strings = Convert.toListStrArray(ids);
        List<Integer> idList = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        MeriHistoryExample example = new MeriHistoryExample();
        example.createCriteria().andIdIn(idList);
        return meriHistoryMapper.deleteByExample(example);

    }

    @Override
    public MeriHistory selectByPrimaryKey(String id) {

        Integer id1 = Integer.valueOf(id);
        return meriHistoryMapper.selectByPrimaryKey(id1);

    }

    @Override
    public int updateByPrimaryKeySelective(MeriHistory record) {
        return meriHistoryMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(MeriHistory record) {

        record.setId(null);

        return meriHistoryMapper.insertSelective(record);
    }

    @Override
    public int updateByExampleSelective(MeriHistory record, MeriHistoryExample example) {

        return meriHistoryMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MeriHistory record, MeriHistoryExample example) {

        return meriHistoryMapper.updateByExample(record, example);
    }

    @Override
    public List<MeriHistory> selectByExample(MeriHistoryExample example) {

        return meriHistoryMapper.selectByExample(example);
    }

    @Override
    public long countByExample(MeriHistoryExample example) {

        return meriHistoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MeriHistoryExample example) {

        return meriHistoryMapper.deleteByExample(example);
    }

    /**
     * 修改权限状态展示或者不展示
     * 
     * @param meriHistory
     * @return
     */
    public int updateVisible(MeriHistory meriHistory) {
        return meriHistoryMapper.updateByPrimaryKeySelective(meriHistory);
    }

}

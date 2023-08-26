package com.nuoquan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.mapper.nq1.LotteryConfigMapper;
import com.nuoquan.pojo.LotteryConfig;
import com.nuoquan.pojo.LotteryConfigExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;
import com.nuoquan.utils.StringUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 奖品配置表 LotteryConfigService
 * 
 * @Title: LotteryConfigService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-08-19 22:47:40  
 **/
@Service
public class LotteryConfigService implements BaseService<LotteryConfig, LotteryConfigExample> {
    @Autowired
    private LotteryConfigMapper lotteryConfigMapper;

    /**
     * 分页查询
     * 
     * @param tablepar
     * @param lotteryConfig
     * @return
     */
    public PageInfo<LotteryConfig> list(TableparV2 tablepar, LotteryConfig lotteryConfig) {
        LotteryConfigExample testExample = new LotteryConfigExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            testExample.createCriteria().andLotteryNameLike("%" + tablepar.getSearchText() + "%");
        }
        //表格排序
        if (StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
            testExample.setOrderByClause(
                    StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) + " " + tablepar.getIsAsc());
        } else {
            testExample.setOrderByClause("id ASC");
        }
        // todo
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<LotteryConfig> list = lotteryConfigMapper.selectByExample(testExample);
        PageInfo<LotteryConfig> pageInfo = new PageInfo<LotteryConfig>(list);
        return pageInfo;
    }

    /**
     * 根据权重查询奖品
     * 
     * @param tablepar
     * @param weightStart
     * @param weightEnd
     * @return
     */
    public PageInfo<LotteryConfig> getLotteryByMerit(TableparV2 tablepar, Integer weightStart, Integer weightEnd) {
        LotteryConfigExample testExample = new LotteryConfigExample();
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        testExample.createCriteria().andMeritStartEqualTo(weightStart).andMeritEndEqualTo(weightEnd);
        List<LotteryConfig> list = lotteryConfigMapper.selectByExample(testExample);
        PageInfo<LotteryConfig> pageInfo = new PageInfo<LotteryConfig>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> strings = Convert.toListStrArray(ids);
        List<Integer> idList = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        LotteryConfigExample example = new LotteryConfigExample();
        example.createCriteria().andIdIn(idList);
        return lotteryConfigMapper.deleteByExample(example);
    }

    @Override
    public LotteryConfig selectByPrimaryKey(String id) {

        Integer id1 = Integer.valueOf(id);
        return lotteryConfigMapper.selectByPrimaryKey(id1);

    }

    @Override
    public int updateByPrimaryKeySelective(LotteryConfig record) {
        return lotteryConfigMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(LotteryConfig record) {

        record.setId(null);

        return lotteryConfigMapper.insertSelective(record);
    }

    @Override
    public int updateByExampleSelective(LotteryConfig record, LotteryConfigExample example) {

        return lotteryConfigMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(LotteryConfig record, LotteryConfigExample example) {

        return lotteryConfigMapper.updateByExample(record, example);
    }

    @Override
    public List<LotteryConfig> selectByExample(LotteryConfigExample example) {

        return lotteryConfigMapper.selectByExample(example);
    }

    @Override
    public long countByExample(LotteryConfigExample example) {

        return lotteryConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(LotteryConfigExample example) {

        return lotteryConfigMapper.deleteByExample(example);
    }

    /**
     * 修改权限状态展示或者不展示
     * 
     * @param lotteryConfig
     * @return
     */
    public int updateVisible(LotteryConfig lotteryConfig) {
        return lotteryConfigMapper.updateByPrimaryKeySelective(lotteryConfig);
    }

}

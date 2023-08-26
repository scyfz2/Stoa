package com.nuoquan.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nuoquan.pojo.User;
import com.nuoquan.pojo.vo.UserVO;
import com.nuoquan.utils.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.nuoquan.mapper.nq1.RankingListMapper;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.RankingListExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.vo.RankListVO;
import com.nuoquan.support.Convert;

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
     * @param tablepar
     * @param rankingList
     * @return
     */
    public PageInfo<RankListVO> list(TableparV2 tablepar, RankingList rankingList) {
        RankingListExample testExample = new RankingListExample();
        //搜索
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
            testExample.createCriteria().andUserIdLike("%" + tablepar.getSearchText() + "%");
        } else {//大搜索
            testExample.createCriteria().andLikeQuery(rankingList);
        }
        testExample.setOrderByClause("date DESC, type asc,sort asc");
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<RankingList> list = rankingListMapper.selectByExample(testExample);

        PageInfo<RankingList> pageInfo = new PageInfo<>(list);
        PageInfo<RankListVO> pageInfoVo = PageUtils.PageInfo2PageInfoVo(pageInfo);
        List<RankListVO> collect = Optional.ofNullable(list).orElse(Lists.newArrayList()).stream().map(x -> {
            RankListVO vo = new RankListVO();
            BeanUtils.copyProperties(x, vo);
            vo.setTypeDesc("1".equals(x.getType()) ? "影响力" : "功德");
            return vo;
        }).collect(Collectors.toList());
        pageInfoVo.setList(collect);
        return pageInfoVo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> strings = Convert.toListStrArray(ids);
        List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
        RankingListExample example = new RankingListExample();
        example.createCriteria().andIdIn(idList);
        return rankingListMapper.deleteByExample(example);
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

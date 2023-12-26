package com.nuoquan.service;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.nuoquan.service.BaseService;
import com.nuoquan.mapper.nq1.LeaderBoardEvaluateStarMapper;
import com.nuoquan.pojo.LeaderBoardEvaluateStar;
import com.nuoquan.pojo.LeaderBoardEvaluateStarExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

/**
 * 排行榜评论点亮表 LeaderBoardEvaluateStarService
 * @Title: LeaderBoardEvaluateStarService.java 
 * @Package com.nuoquan.admin.service 
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:37  
 **/
@Service
public class LeaderBoardEvaluateStarService implements BaseService<LeaderBoardEvaluateStar, LeaderBoardEvaluateStarExample>{
	@Autowired
	private LeaderBoardEvaluateStarMapper leaderBoardEvaluateStarMapper;
	
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @return
	 */
	 public PageInfo<LeaderBoardEvaluateStar> list(TableparV2 tablepar,LeaderBoardEvaluateStar leaderBoardEvaluateStar){
	        LeaderBoardEvaluateStarExample testExample=new LeaderBoardEvaluateStarExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(leaderBoardEvaluateStar);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<LeaderBoardEvaluateStar> list= leaderBoardEvaluateStarMapper.selectByExample(testExample);
	        PageInfo<LeaderBoardEvaluateStar> pageInfo = new PageInfo<LeaderBoardEvaluateStar>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {

			List<String> strings = Convert.toListStrArray(ids);
			List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
			LeaderBoardEvaluateStarExample example=new LeaderBoardEvaluateStarExample();
			example.createCriteria().andIdIn(idList);
			return leaderBoardEvaluateStarMapper.deleteByExample(example);


	}
	
	
	@Override
	public LeaderBoardEvaluateStar selectByPrimaryKey(String id) {
		
			Long id1 = Long.valueOf(id);
			return leaderBoardEvaluateStarMapper.selectByPrimaryKey(id1);
			
		
	}

	
	@Override
	public int updateByPrimaryKeySelective(LeaderBoardEvaluateStar record) {
		return leaderBoardEvaluateStarMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(LeaderBoardEvaluateStar record) {
		
		record.setId(null);
		
		
		return leaderBoardEvaluateStarMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(LeaderBoardEvaluateStar record, LeaderBoardEvaluateStarExample example) {
		
		return leaderBoardEvaluateStarMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(LeaderBoardEvaluateStar record, LeaderBoardEvaluateStarExample example) {
		
		return leaderBoardEvaluateStarMapper.updateByExample(record, example);
	}

	@Override
	public List<LeaderBoardEvaluateStar> selectByExample(LeaderBoardEvaluateStarExample example) {
		
		return leaderBoardEvaluateStarMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(LeaderBoardEvaluateStarExample example) {
		
		return leaderBoardEvaluateStarMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(LeaderBoardEvaluateStarExample example) {
		
		return leaderBoardEvaluateStarMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param leaderBoardEvaluateStar
	 * @return
	 */
	public int updateVisible(LeaderBoardEvaluateStar leaderBoardEvaluateStar) {
		return leaderBoardEvaluateStarMapper.updateByPrimaryKeySelective(leaderBoardEvaluateStar);
	}


}

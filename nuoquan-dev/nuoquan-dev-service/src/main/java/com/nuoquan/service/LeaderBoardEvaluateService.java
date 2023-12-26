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
import com.nuoquan.mapper.nq1.LeaderBoardEvaluateMapper;
import com.nuoquan.pojo.LeaderBoardEvaluate;
import com.nuoquan.pojo.LeaderBoardEvaluateExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

/**
 * 排行榜评论表 LeaderBoardEvaluateService
 * @Title: LeaderBoardEvaluateService.java 
 * @Package com.nuoquan.admin.service 
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:35  
 **/
@Service
public class LeaderBoardEvaluateService implements BaseService<LeaderBoardEvaluate, LeaderBoardEvaluateExample>{
	@Autowired
	private LeaderBoardEvaluateMapper leaderBoardEvaluateMapper;
	
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @return
	 */
	 public PageInfo<LeaderBoardEvaluate> list(TableparV2 tablepar,LeaderBoardEvaluate leaderBoardEvaluate){
	        LeaderBoardEvaluateExample testExample=new LeaderBoardEvaluateExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(leaderBoardEvaluate);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<LeaderBoardEvaluate> list= leaderBoardEvaluateMapper.selectByExample(testExample);
	        PageInfo<LeaderBoardEvaluate> pageInfo = new PageInfo<LeaderBoardEvaluate>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {

			List<String> strings = Convert.toListStrArray(ids);
			List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
			LeaderBoardEvaluateExample example=new LeaderBoardEvaluateExample();
			example.createCriteria().andIdIn(idList);
			return leaderBoardEvaluateMapper.deleteByExample(example);


	}
	
	
	@Override
	public LeaderBoardEvaluate selectByPrimaryKey(String id) {
		
			Long id1 = Long.valueOf(id);
			return leaderBoardEvaluateMapper.selectByPrimaryKey(id1);
			
		
	}

	
	@Override
	public int updateByPrimaryKeySelective(LeaderBoardEvaluate record) {
		return leaderBoardEvaluateMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(LeaderBoardEvaluate record) {
		
		record.setId(null);
		
		
		return leaderBoardEvaluateMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(LeaderBoardEvaluate record, LeaderBoardEvaluateExample example) {
		
		return leaderBoardEvaluateMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(LeaderBoardEvaluate record, LeaderBoardEvaluateExample example) {
		
		return leaderBoardEvaluateMapper.updateByExample(record, example);
	}

	@Override
	public List<LeaderBoardEvaluate> selectByExample(LeaderBoardEvaluateExample example) {
		
		return leaderBoardEvaluateMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(LeaderBoardEvaluateExample example) {
		
		return leaderBoardEvaluateMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(LeaderBoardEvaluateExample example) {
		
		return leaderBoardEvaluateMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param leaderBoardEvaluate
	 * @return
	 */
	public int updateVisible(LeaderBoardEvaluate leaderBoardEvaluate) {
		return leaderBoardEvaluateMapper.updateByPrimaryKeySelective(leaderBoardEvaluate);
	}


}

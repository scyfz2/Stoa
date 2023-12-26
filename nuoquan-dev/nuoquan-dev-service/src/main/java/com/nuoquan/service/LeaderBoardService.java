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
import com.nuoquan.mapper.nq1.LeaderBoardMapper;
import com.nuoquan.pojo.LeaderBoard;
import com.nuoquan.pojo.LeaderBoardExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

/**
 * 排行榜主表 LeaderBoardService
 * @Title: LeaderBoardService.java 
 * @Package com.nuoquan.admin.service 
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:01:06  
 **/
@Service
public class LeaderBoardService implements BaseService<LeaderBoard, LeaderBoardExample>{
	@Autowired
	private LeaderBoardMapper leaderBoardMapper;
	
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @return
	 */
	 public PageInfo<LeaderBoard> list(TableparV2 tablepar,LeaderBoard leaderBoard){
	        LeaderBoardExample testExample=new LeaderBoardExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(leaderBoard);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<LeaderBoard> list= leaderBoardMapper.selectByExample(testExample);
	        PageInfo<LeaderBoard> pageInfo = new PageInfo<LeaderBoard>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {

			List<String> strings = Convert.toListStrArray(ids);
			List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
			LeaderBoardExample example=new LeaderBoardExample();
			example.createCriteria().andIdIn(idList);
			return leaderBoardMapper.deleteByExample(example);


	}
	
	
	@Override
	public LeaderBoard selectByPrimaryKey(String id) {
		
			Long id1 = Long.valueOf(id);
			return leaderBoardMapper.selectByPrimaryKey(id1);
			
		
	}

	
	@Override
	public int updateByPrimaryKeySelective(LeaderBoard record) {
		return leaderBoardMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(LeaderBoard record) {
		
		record.setId(null);
		
		
		return leaderBoardMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(LeaderBoard record, LeaderBoardExample example) {
		
		return leaderBoardMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(LeaderBoard record, LeaderBoardExample example) {
		
		return leaderBoardMapper.updateByExample(record, example);
	}

	@Override
	public List<LeaderBoard> selectByExample(LeaderBoardExample example) {
		
		return leaderBoardMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(LeaderBoardExample example) {
		
		return leaderBoardMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(LeaderBoardExample example) {
		
		return leaderBoardMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param leaderBoard
	 * @return
	 */
	public int updateVisible(LeaderBoard leaderBoard) {
		return leaderBoardMapper.updateByPrimaryKeySelective(leaderBoard);
	}


}

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
import com.nuoquan.mapper.nq1.LeaderBoardObjectMapper;
import com.nuoquan.pojo.LeaderBoardObject;
import com.nuoquan.pojo.LeaderBoardObjectExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

/**
 * 排行榜主表 LeaderBoardObjectService
 * @Title: LeaderBoardObjectService.java 
 * @Package com.nuoquan.admin.service 
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:38  
 **/
@Service
public class LeaderBoardObjectService implements BaseService<LeaderBoardObject, LeaderBoardObjectExample>{
	@Autowired
	private LeaderBoardObjectMapper leaderBoardObjectMapper;
	
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @return
	 */
	 public PageInfo<LeaderBoardObject> list(TableparV2 tablepar,LeaderBoardObject leaderBoardObject){
	        LeaderBoardObjectExample testExample=new LeaderBoardObjectExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(leaderBoardObject);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<LeaderBoardObject> list= leaderBoardObjectMapper.selectByExample(testExample);
	        PageInfo<LeaderBoardObject> pageInfo = new PageInfo<LeaderBoardObject>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {

			List<String> strings = Convert.toListStrArray(ids);
			List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
			LeaderBoardObjectExample example=new LeaderBoardObjectExample();
			example.createCriteria().andIdIn(idList);
			return leaderBoardObjectMapper.deleteByExample(example);


	}
	
	
	@Override
	public LeaderBoardObject selectByPrimaryKey(String id) {
		
			Long id1 = Long.valueOf(id);
			return leaderBoardObjectMapper.selectByPrimaryKey(id1);
			
		
	}

	
	@Override
	public int updateByPrimaryKeySelective(LeaderBoardObject record) {
		return leaderBoardObjectMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(LeaderBoardObject record) {
		
		record.setId(null);
		
		
		return leaderBoardObjectMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(LeaderBoardObject record, LeaderBoardObjectExample example) {
		
		return leaderBoardObjectMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(LeaderBoardObject record, LeaderBoardObjectExample example) {
		
		return leaderBoardObjectMapper.updateByExample(record, example);
	}

	@Override
	public List<LeaderBoardObject> selectByExample(LeaderBoardObjectExample example) {
		
		return leaderBoardObjectMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(LeaderBoardObjectExample example) {
		
		return leaderBoardObjectMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(LeaderBoardObjectExample example) {
		
		return leaderBoardObjectMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param leaderBoardObject
	 * @return
	 */
	public int updateVisible(LeaderBoardObject leaderBoardObject) {
		return leaderBoardObjectMapper.updateByPrimaryKeySelective(leaderBoardObject);
	}


}

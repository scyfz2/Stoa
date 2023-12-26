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
import com.nuoquan.mapper.nq1.LeaderBoardTagMapper;
import com.nuoquan.pojo.LeaderBoardTag;
import com.nuoquan.pojo.LeaderBoardTagExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.support.Convert;

/**
 * 排行榜评论点亮表 LeaderBoardTagService
 * @Title: LeaderBoardTagService.java 
 * @Package com.nuoquan.admin.service 
 * @author xxdd_自动生成
 * @email ${email}
 * @date 2023-12-23 15:05:39  
 **/
@Service
public class LeaderBoardTagService implements BaseService<LeaderBoardTag, LeaderBoardTagExample>{
	@Autowired
	private LeaderBoardTagMapper leaderBoardTagMapper;
	
	
	/**
	 * 分页查询
	 * @param tablepar
	 * @return
	 */
	 public PageInfo<LeaderBoardTag> list(TableparV2 tablepar,LeaderBoardTag leaderBoardTag){
	        LeaderBoardTagExample testExample=new LeaderBoardTagExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(leaderBoardTag);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<LeaderBoardTag> list= leaderBoardTagMapper.selectByExample(testExample);
	        PageInfo<LeaderBoardTag> pageInfo = new PageInfo<LeaderBoardTag>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {

			List<String> strings = Convert.toListStrArray(ids);
			List<Long> idList = strings.stream().map(Long::parseLong).collect(Collectors.toList());
			LeaderBoardTagExample example=new LeaderBoardTagExample();
			example.createCriteria().andIdIn(idList);
			return leaderBoardTagMapper.deleteByExample(example);


	}
	
	
	@Override
	public LeaderBoardTag selectByPrimaryKey(String id) {
		
			Long id1 = Long.valueOf(id);
			return leaderBoardTagMapper.selectByPrimaryKey(id1);
			
		
	}

	
	@Override
	public int updateByPrimaryKeySelective(LeaderBoardTag record) {
		return leaderBoardTagMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(LeaderBoardTag record) {
		
		record.setId(null);
		
		
		return leaderBoardTagMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(LeaderBoardTag record, LeaderBoardTagExample example) {
		
		return leaderBoardTagMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(LeaderBoardTag record, LeaderBoardTagExample example) {
		
		return leaderBoardTagMapper.updateByExample(record, example);
	}

	@Override
	public List<LeaderBoardTag> selectByExample(LeaderBoardTagExample example) {
		
		return leaderBoardTagMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(LeaderBoardTagExample example) {
		
		return leaderBoardTagMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(LeaderBoardTagExample example) {
		
		return leaderBoardTagMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param leaderBoardTag
	 * @return
	 */
	public int updateVisible(LeaderBoardTag leaderBoardTag) {
		return leaderBoardTagMapper.updateByPrimaryKeySelective(leaderBoardTag);
	}


}

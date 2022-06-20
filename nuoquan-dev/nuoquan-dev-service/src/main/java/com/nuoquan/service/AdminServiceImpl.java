package com.nuoquan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nuoquan.mapper.nq1.AdminNoticeMapper;
import com.nuoquan.mapper.nq1.AdminUserMapper;
import com.nuoquan.mapper.nq1.AdminUserNoticeMapper;
import com.nuoquan.pojo.AdminUser;
import com.nuoquan.pojo.AdminUserNotice;
import com.nuoquan.pojo.AdminNotice;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired 
	private AdminUserMapper adminUserMapper;
	
	@Autowired
	private AdminNoticeMapper adminNoticeMapper;
	
	@Autowired
	private AdminUserNoticeMapper adminUserNoticeMapper;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public AdminUser queryAdminUserName(String username) {
		Example example = new Example(AdminUser.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
		
		List<AdminUser> result = adminUserMapper.selectByExample(example);
		if (result.size() >= 0) {
			return result.get(0); // Return the first one, although it should have only one.
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<AdminNotice> getUserNotice(AdminUser adminUser, int state){
		List<AdminNotice> notices=new ArrayList<>();
		//查询公告用户外键
		Example userNoticeExample=new Example(AdminUserNotice.class);
		Criteria criteria= userNoticeExample.createCriteria();
		criteria.andEqualTo("userId", adminUser.getId());
		if(-1!=state) {
			criteria.andEqualTo("state", state);
		}
		List<AdminUserNotice> userNotices= adminUserNoticeMapper.selectByExample(userNoticeExample);
		if(userNotices!=null&&userNotices.size()>0) {
			//查询对应的公告列表
			List<String> ids=new ArrayList<String>();
			for (AdminUserNotice userNotice : userNotices) {
				ids.add(userNotice.getNoticeId());
			}
			Example noticeExample = new Example(AdminNotice.class);
			noticeExample.createCriteria().andEqualTo("id",ids);
			notices=adminNoticeMapper.selectByExample(noticeExample);
		}
		return notices;
	}
	
}

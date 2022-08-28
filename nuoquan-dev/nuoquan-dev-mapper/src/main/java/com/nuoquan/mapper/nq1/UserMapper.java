package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.User;
import com.nuoquan.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {
	
	
	/**
	 * @Des: 用户受喜欢数累加
	 * @param userId
	 */
	public void addReceiveLikeCount(String userId);
	
	/**
	 * @Des: 用户受喜欢数累减
	 * @param userId
	 */
	public void reduceReceiveLikeCount(String userId);
	
	/**
	 * @Description: 增加粉丝数
	 */
	public void addFansCount(String userId);
	
	/**
	 * @Description: 增加粉丝数
	 */
	public void reduceFansCount(String userId);
	
	/**
	 * @Description: 增加关注数
	 */
	public void addFollowCount(String userId);
	
	/**
	 * @Description: 减少关注数
	 */
	public void reduceFollowCount(String userId);
}
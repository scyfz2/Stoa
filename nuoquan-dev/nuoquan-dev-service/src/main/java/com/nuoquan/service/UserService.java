package com.nuoquan.service;

import java.util.List;

import com.nuoquan.pojo.ChatMsg;
import com.nuoquan.pojo.User;
import com.nuoquan.pojo.netty.ChatMessage;
import com.nuoquan.pojo.vo.UserVO;

public interface UserService {
	/**
	 * @Description: 判断id是否存在
	 * @param id
	 * @return
	 */
	public boolean checkIdIsExist(String id);
	
	/**
	 * @param nickname 昵称
	 * @return true:昵称不存在，可以使用；false: 昵称存在，需要更换
	 * @Description: 判断nickname是否已经存在
	 */
	public boolean checkNicknameIsExist(String nickname);
	
	/**
	 * 保存用户（用户注册）
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 直接保存用户，不自动生成id
	 * @param user
	 */
	public UserVO saveUserDirectly(User user);
	
	/**
	 * @Description: 用户登录，根据用户名和密码查询用户
	 */
	public User checkUserForLogin(String nickname, String password);
	
	/**
	 * @Description: 修改用户记录
	 */
	public UserVO updateUserInfo(User user);
	
	/**
	 * @Description: 根据用户 Id 查询该用户信息
	 */
	public UserVO getUserById(String userId);
	
	/**
	 * @Description 增加用户粉丝关系
	 * @param userId
	 * @param fanId
	 */
	public void saveUserFanRelation(String userId, String fanId);
	
	/**
	 * @Description 删除用户粉丝关系
	 * @param userId
	 * @param fanId
	 */
	public void deleteUserFanRelation(String userId, String fanId);
	
	/**
	 * 查询用户是否关注
	 * @param userId
	 * @param fanId
	 * @return
	 */
	public boolean queryIfFollow(String userId, String fanId);
	
	/**
	 * @Description 查询用户粉丝列表, 以及我是否关注
	 * @param userId
	 * @param myId
	 */
	public List<UserVO> queryUserFans(String userId, String myId);
	
	/**
	 * @Description 查询用户关注列表，以及我是否关注
	 * @param userId
	 * @param myId
	 */
	public List<UserVO> queryUserFollow(String userId, String myId);
	
	/**
	 * @Description 保存聊天消息到数据库
	 * @param chatMessage
	 * @return msgId
	 */
	public String saveMsg(ChatMessage chatMessage);
	
	/**
	 * @Description 批量签收聊天消息
	 */
	public void updateChatSigned(List<String> msgIdList);
	
	/**
	 * 获取未签收聊天消息列表
	 * @param acceptUserId
	 * @return
	 */
	public List<ChatMsg> getUnsignedChat(String acceptUserId);

	/**
	 * 更新用户的影响力数值
	 * @param userId
	 * @param value ReputeWeight枚举类
	 * @param op 1=增加 -1=减少 
	 * @return
	 */
	public boolean updateReputation(String userId, Integer value, int op);

	/**
	 * 更新用户最近登录的时间
	 * @param userId
	 */
	public void updateLatestLoginTime(String userId);

	/**
	 * 累加用户获赞数
	 * @param userId
	 */
	public void addReceiveLikeCount(String userId);

	/**
	 * 累减用户获赞数
	 * @param userId
	 */
	public void reduceReceiveLikeCount(String userId);
}

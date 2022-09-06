package com.nuoquan.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.nuoquan.mapper.nq1.*;
import com.nuoquan.utils.SensitiveFilterUtil;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nuoquan.enums.SignFlagEnum;
import com.nuoquan.pojo.ChatMsg;
import com.nuoquan.pojo.User;
import com.nuoquan.pojo.UserFans;
import com.nuoquan.pojo.netty.ChatMessage;
import com.nuoquan.pojo.vo.UserVO;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Descprition 用户相关操作的服务类
 * @Author jerrio
 * @Date 2020.8.24
 */
//service注解，不加注解SpringBoot扫描不到
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserFansMapper userFansMapper;
	@Autowired
	private UserFansMapperCustom userFansMapperCustom;
	@Autowired
	private Sid sid;
	@Autowired
	private ChatMsgMapper chatMsgMapper;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private SensitiveFilterUtil sensitiveFilterUtil;
	@Autowired
	private UserBanDetailMapper userBanDetailMapper;

	/**
	 * 将user转换为UserVO 并为用户添加vo属性
	 * @param user
	 * @return
	 */
	private UserVO composeUser(User user) {
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(user, userVO);
		userVO.setFaceImg(resourceService.composeUrl(userVO.getFaceImg()));
		userVO.setFaceImgThumb(resourceService.composeUrl(userVO.getFaceImgThumb()));
		return userVO;
	}

	/**
	 * 为用户添加vo属性
	 * @param userVO
	 * @return
	 */
	private UserVO composeUser(UserVO userVO) {
		userVO.setFaceImg(resourceService.composeUrl(userVO.getFaceImg()));
		userVO.setFaceImgThumb(resourceService.composeUrl(userVO.getFaceImgThumb()));
		userVO.setSignature(sensitiveFilterUtil.filter(userVO.getSignature()));
		return userVO;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean checkIdIsExist(String id) {
		User user = new User();
		// 条件
		user.setId(id);
		//判断result是否为空
		User result = userMapper.selectOne(user);
		return result == null ? false : true;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean checkNicknameIsExist(String nickname) {
		User user = new User();
		// 条件
		user.setNickname(nickname);
		//判断result是否为空
		User result = userMapper.selectOne(user);
		return result == null ? false : true;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean checkEmailIsExist(String email) {
		User user = new User();
		// 条件
		user.setEmail(email);
		//判断result是否为空
		User result = userMapper.selectOne(user);
		return result == null ? false : true;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(User user) {

		String userid = sid.nextShort();
		user.setId(userid);
		// 保存一个实体，null值不会保存，使用数据库默认值
		userMapper.insertSelective(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public UserVO saveUserDirectly(User user) {
		userMapper.insertSelective(user);
		return getUserById(user.getId());
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User checkUserForLogin(String nickname, String password) {

		Example userExample = new Example(User.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("nickname", nickname);
		criteria.andEqualTo("password", password);
		User result = userMapper.selectOneByExample(userExample);

		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public UserVO updateUserInfo(User user) {

		userMapper.updateByPrimaryKeySelective(user);
		return getUserById(user.getId());
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public UserVO getUserById(String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return composeUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUserFanRelation(String userId, String fanId) {

		// 保存到 users_fans关系表
		String relId = sid.nextShort();

		UserFans userFan = new UserFans();
		userFan.setId(relId);
		userFan.setUserId(userId);
		userFan.setFansId(fanId);

		userFansMapper.insert(userFan);
		// 更新用户信息
		userMapper.addFansCount(userId);
		userMapper.addFollowCount(fanId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteUserFanRelation(String userId, String fanId) {

		Boolean isFollow = queryIfFollow(userId, fanId);
		if (isFollow) {
			// 有数据才删除并减少count
			Example example = new Example(UserFans.class);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("userId", userId);
			criteria.andEqualTo("fansId", fanId);

			userFansMapper.deleteByExample(example);

			userMapper.reduceFansCount(userId);
			userMapper.reduceFollowCount(fanId);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<UserVO> queryUserFans(String userId, String myId) {

		List<UserVO> list = userFansMapperCustom.queryFansInfo(userId);
		for (UserVO u : list) {
			if (u != null) {
				// 逐个查询我是否关注
				Boolean isFollow = queryIfFollow(u.getId(), myId);
				u.setFollow(isFollow);
				u = composeUser(u);
			}
		}
		return list;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<UserVO> queryUserFollow(String userId, String myId) {

		List<UserVO> list = userFansMapperCustom.queryFollowInfo(userId);
		List<UserVO> newList = new ArrayList<UserVO>();
		for (UserVO u : list) {
			// 逐个查询我是否关注
			if (u!=null) { //移除空对象，提高容错
				Boolean isFollow = queryIfFollow(u.getId(), myId);
				u.setFollow(isFollow);
				u = composeUser(u);
				newList.add(u);
			}
		}
		return newList;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryIfFollow(String userId, String fanId) {
		if (StringUtils.isEmpty(userId)||StringUtils.isEmpty(fanId)) {
			return false;
		}

		Example example = new Example(UserFans.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userId", userId);
		criteria.andEqualTo("fansId", fanId);

		List<UserFans> list = userFansMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String saveMsg(ChatMessage chatMessage) {
		ChatMsg msgDB = new ChatMsg();
		String msgId = sid.nextShort();
		msgDB.setId(msgId);
		msgDB.setAcceptUserId(chatMessage.getReceiverId());
		msgDB.setSendUserId(chatMessage.getSenderId());
		msgDB.setSignFlag(SignFlagEnum.UNSIGN.type);
		msgDB.setCreateDate(chatMessage.getCreateDate());
		msgDB.setMsg(chatMessage.getMsg());

		chatMsgMapper.insert(msgDB);

		return msgId;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateChatSigned(List<String> msgIdList) {
		chatMsgMapper.batchUpdateMsgSigned(msgIdList);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<ChatMsg> getUnsignedChat(String acceptUserId) {

		Example chatExample = new Example(ChatMsg.class);
		Criteria chatCriteria = chatExample.createCriteria();
		chatCriteria.andEqualTo("signFlag", SignFlagEnum.UNSIGN.type);
		chatCriteria.andEqualTo("acceptUserId", acceptUserId);

		 List<ChatMsg> result = chatMsgMapper.selectByExample(chatExample);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean updateReputation(String userId, Integer value, int op) {
		User user = userMapper.selectByPrimaryKey(userId);
		Integer reputation = user.getReputation();
		//仅更新reputation
		User userNew = new User();
		if (op>0) {
			reputation += value;
		}else {
			reputation -= value;
		}
		userNew.setId(userId);
		userNew.setReputation(reputation);
		userMapper.updateByPrimaryKeySelective(userNew);
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateLatestLoginTime(String userId) {
		Example example = new Example(UserFans.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", userId);
		User user = new User();
		user.setLatestLogin(new Date());
		userMapper.updateByExampleSelective(user, example);
	}

	/**
	 * 累加用户获赞数
	 * @param userId
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addReceiveLikeCount(String userId){
		userMapper.addReceiveLikeCount(userId);
	}

	/**
	 * 累减用户获赞数
	 * @param userId
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void reduceReceiveLikeCount(String userId){
		userMapper.reduceReceiveLikeCount(userId);
	}

	/**
	 * 判断用户名是否合法
	 */
	@Override
	public boolean judgeNickNameIsValid(String nickName){
		if (nickName.equals(sensitiveFilterUtil.filter(nickName))){
			return true;
		}
		else
			return false;
	}

	/**
	 * 判断该用户是否被禁言，如果被禁言则判断该用户的禁言日期是否到达，如果到达则使该用户状态变为1（正常）
	 * @param userId
	 * @return
	 */
	@Override
	public void judgeUserState(String userId) throws ParseException {
		int state = userMapper.selectByPrimaryKey(userId).getState();
		// 如果用户状态为禁言
		if (state == 0) {
			// 获得此用户结束禁言最晚的时间
			String endDate = userBanDetailMapper.selectEndDate(userId);
			// 获得当前时间并将其转换为String
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentDate = formatter.format(calendar.getTime());
			// 比较当前时间与此用户结束禁言最晚的时间，若当前时间已超过结束禁言最晚的时间则恢复此用户状态为正常
			DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (sf.parse(endDate).getTime() < sf.parse(currentDate).getTime()){
				userMapper.changeStateToNormal(userId);
			}
		}
	}

}

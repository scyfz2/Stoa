package com.nuoquan.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.enums.PostType;
import com.nuoquan.mapper.nq1.*;
import com.nuoquan.pojo.Article;
import com.nuoquan.pojo.vo.ArticleVO;
import com.nuoquan.pojo.vo.UserVO;
import com.nuoquan.utils.PagedResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private UserService userService;

	@Autowired
	private SocialService socialService;

	@Autowired
	private ArticleServiceImpl articleService;

	@Autowired
	private ArticleMapper articleMapper;

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

	@Override
	public ArticleVO composeArticleVOAdmin(ArticleVO articleVO, String userId) {
		// 组合作者头像url
		UserVO userVO = userService.getUserById(articleVO.getUserId());
		articleVO.setNickname(userVO.getNickname());
		articleVO.setFaceImg(userVO.getFaceImg());
		articleVO.setFaceImgThumb(userVO.getFaceImgThumb());
		// 添加图片列表
		articleVO = articleService.addArticleImgs(articleVO);
		// 添加和关于用户的点赞关系
		articleVO.setIsLike(socialService.isUserLike(userId, PostType.ARTICLE, articleVO.getId()));
		// 添加和关于用户的收藏关系
		articleVO.setIsCollect(socialService.isUserCollect(userId, PostType.ARTICLE, articleVO.getId()));
		// 添加标签列表
		if (!StringUtils.isBlank(articleVO.getTags())) {
			String[] tagList = articleVO.getTags().split("#");
			List<String> finalTagList = new ArrayList<String>();
			for (String tag : tagList) {
				if (!StringUtils.isBlank(tag)) {
					finalTagList.add(tag);
				}
			}
			articleVO.setTagList(finalTagList);
		}

		return articleVO;
	}

	/**
	 * 把 Article 转换为 ArticleVO, 组装文章VO对象
	 * @param article
	 * @param userId 操作者（我）
	 * @return
	 */
	@Override
	public ArticleVO composeArticleVOAdmin(Article article, String userId) {
		ArticleVO articleVO = new ArticleVO();
		BeanUtils.copyProperties(article, articleVO);
		return composeArticleVOAdmin(articleVO, userId);
	}

	@Override
	public ArticleVO getArticleByIdAdmin(String articleId, String userId) {
		Article article = articleMapper.selectByPrimaryKey(articleId);
		ArticleVO articleVO = composeArticleVOAdmin(article, userId);
		return articleVO;
	}

	
}

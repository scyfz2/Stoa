package com.nuoquan.service;

import java.util.List;

import com.nuoquan.enums.PostType;
import com.nuoquan.pojo.AdminUser;
import com.nuoquan.pojo.AdminNotice;
import com.nuoquan.pojo.Article;
import com.nuoquan.pojo.vo.ArticleVO;
import com.nuoquan.utils.PagedResult;

/**
 * 后台管理业务接口类
 * @author Jerrio
 */
public interface AdminService {
	/**
	 * 查询后台管理员用户信息
	 * @param username
	 * @return 用户对象
	 */
	public AdminUser queryAdminUserName(String username);
		
	/**
	 * 获取用户公告
	 * @param adminUser
	 * @param state 阅读状态  0未阅读 1 阅读  -1全部
	 * @return
	 */
	public List<AdminNotice> getUserNotice(AdminUser adminUser, int state);

	ArticleVO composeArticleVOAdmin(ArticleVO articleVO, String userId);

	ArticleVO composeArticleVOAdmin(Article article, String userId);

	ArticleVO getArticleByIdAdmin(String articleId, String userId);

	PagedResult getReportedPublished(Integer page, Integer pageSize, String userId, PostType targetType, Integer queryType);

}
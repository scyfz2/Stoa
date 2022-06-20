package com.nuoquan.controller;

import com.nuoquan.enums.*;
import com.nuoquan.pojo.*;
import com.nuoquan.utils.JSONResult;
import com.nuoquan.utils.PagedResult;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@Api(value = "文章相关接口", tags = { "Article-Controller" })
@RequestMapping("/article")
public class ArticleController extends BasicController {

	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @param queryType 0 -- 按"所有"请求, 1 -- 按"关注"请求
	 * @param orderType 0 -- 按时间倒序排列, 1 -- 按热度正序排列
	 * @param userId 操作者id
	 * @param selectedTag 选中的标签, 如果为空则正常显示所有文章, 不为空, 则根据传进来的值查询对应文章(拥有该标签的文章)
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "查询全部文章", notes = "查询全部文章的接口")
	@ApiImplicitParams({
		// userId 查询用户和文章的点赞关系
		// dataType 为 String, 应该改为 Integer
		@ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "queryType", value = "排列方式", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "orderType", value = "排列方式", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "selectedTag", value = "选择的标签", required = false, dataType = "String", paramType = "form")
		})
	@PostMapping("/queryArticles")
	public JSONResult queryArticles(Integer page, Integer pageSize, Integer queryType, Integer orderType, String userId, String selectedTag) throws Exception {
		
		if(page == null) {
			page = 1;
		}
		
		if(pageSize == null) {
			pageSize = PAGE_SIZE;
		}

		PagedResult result = articleService.queryArticle(page, pageSize, queryType, userId, selectedTag);
		
		return JSONResult.ok(result);
	}
	
//	/**
//	 *
//	 * @param page
//	 * @param pageSize
//	 * @param type 0 -- 按时间倒序排列, 1 -- 按热度正序排列
//	 * @param userId
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	@ApiOperation(value = "查询我关注的人的全部文章", notes = "查询我关注的人的全部文章的接口")
//	@ApiImplicitParams({
//		// userId 查询用户和文章的点赞关系
//		// dataType 为 String, 应该改为 Integer
//		@ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form"),
//		@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "String", paramType = "form"),
//		@ApiImplicitParam(name = "type", value = "文章的排列方式", required = true, dataType = "Integer", paramType = "form"),
//		@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "String", paramType = "form") })
//	@PostMapping("/queryAllSubscribedAuthorArticles")
//	public JSONResult queryAllSubscribedAuthorArticles(Integer page, Integer pageSize, Integer type, String userId) throws Exception {
//
//		PagedResult result = new PagedResult();
//
//		if (page == null) {
//			page = 1;
//		}
//		if (pageSize == null) {
//			pageSize = PAGE_SIZE;
//		}
//
//		if (type == 0) {
//			result = articleService.getAllSubscribedAuthorArticles(page, pageSize, userId);
//		}
//
//		if (type == 1) {
//			result = articleService.getAllSubscribedAuthorArticlesByPopularity(page, pageSize, userId);
//		}
//
//		return JSONResult.ok(result);
//	}
	
	@ApiOperation(value = "查询我的发布的文章和他人发布的文章", notes = "查看他人时只能查看status为1的, 查询自己时,可显示所有status")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "targetId", value = "目标查询者id", required = true, dataType = "String", paramType = "form")
	})
	@PostMapping("/queryPublishHistory")
	public JSONResult queryPublishHistory(Integer page, Integer pageSize, String userId, String targetId) {
		
		PagedResult finalResult = new PagedResult();
		
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		if(userId.equals(targetId)) {
			// 查询所有状态的文章
			PagedResult result = articleService.getAllMyHisArticle(page, pageSize, userId);
			finalResult = result;
		} else if (!userId.equals(targetId)) {
			// 查询他人文章状态为1的文章
			PagedResult result = articleService.gerOtherslegalHisArticle(page, pageSize, userId, targetId);
			finalResult = result;
		}
		
		return JSONResult.ok(finalResult);
		
	}

	@ApiOperation(value = "更改文章状态为unreadable")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "String", paramType = "form")
	})
	@PostMapping(value="/fDeleteArticle")
	public JSONResult fDeleteArticle(String articleId) throws Exception {
		articleService.fDeleteArticle(articleId);
		return JSONResult.ok();
	}

	@ApiOperation(value = "按文章 id 查询文章", notes = "查询全部文章的接口")
	@ApiImplicitParams({
		// userId 查询用户和文章的点赞关系
		@ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form") })
	@PostMapping("/getArticleById")
	public JSONResult getArticleById(String articleId, String userId) throws Exception {

		return JSONResult.ok(articleService.getArticleById(articleId, userId));
	}


	/**
	 * 分页和搜索文章 isSaveRecord：1 = 需要保存 0/null = 不需要保存
	 * 
	 * @param searchText
	 * @param isSaveRecord
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "综合搜索")
	@PostMapping(value = "/searchArticleYANG")
	public JSONResult searchArticleYang(String searchText, Integer isSaveRecord, Integer page, String userId)
			throws Exception {

		if (page == null) {
			page = 1;
		}
		
		PagedResult result = articleService.searchArticleYang(isSaveRecord, page, PAGE_SIZE, searchText, userId);
		return JSONResult.ok(result);
	}

	@PostMapping(value = "/hot")
	public JSONResult hot() throws Exception {
		return JSONResult.ok(articleService.getHotWords());
	}

	@ApiOperation(value = "上传文章", notes = "上传文章的接口")
	@ApiImplicitParams({
		// uniapp使用formData时，paramType要改成form
		@ApiImplicitParam(name="userId", value="作者id", required=true, dataType="String", paramType="form"),
		@ApiImplicitParam(name="articleTag", value="文章标签", required=false, dataType="String", paramType="form"),
		@ApiImplicitParam(name="articleTitle", value="文章题目", required=true, dataType="String", paramType="form"),
		@ApiImplicitParam(name="articleContent", value="文章内容", required=true, dataType="String", paramType="form")
	})	
	@PostMapping(value="/uploadArticle")
	public JSONResult upload(String userId, String articleTag, String articleTitle, String articleContent) throws Exception {
		
		if (StringUtils.isBlank(userId) || StringUtils.isEmpty(userId)) {
			return JSONResult.errorMsg("Id can't be null");
		}
		boolean isLegal = false;
		// 保存文章信息到数据库
		Article article = new Article();
		article.setArticleTitle(articleTitle);
		article.setArticleContent(articleContent);
		article.setUserId(userId);
		article.setTags(articleTag);
		article.setCreateDate(new Date());
		// 检测内容是否非法
		if (weChatService.msgSecCheck(articleTitle) 
			&& weChatService.msgSecCheck(articleTag)
			&& weChatService.msgSecCheck(articleContent)) {
			// 合法
			isLegal = true;
			if (resourceConfig.getAutoCheckArticle()) { //查看是否设置自动过审
				article.setStatus(StatusEnum.READABLE.type);
			}else {
				article.setStatus(StatusEnum.CHECKING.type);
			}
		} else {
			// 非法，尽管非法也保存到数据库
			article.setStatus(StatusEnum.DELETED.type);
		}
		String articleId = articleService.saveArticle(article); // 存入数据库
		
		if (isLegal) {
			return JSONResult.ok(articleId);
		}else {
			return JSONResult.errorMsg("内容违规");
		}
	}
	
	/**
	 * @param userId
	 * @param articleId
	 * @param order 作为文件名 保证序列和发送一直
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/uploadArticleImg")
	public JSONResult uploadArticleImg(String userId ,String articleId, String order, @ApiParam(value="file", required=true) MultipartFile file) throws Exception {

		if (StringUtils.isNoneBlank(userId) && file != null) {
			// 判断是否超出大小限制
			if (file.getSize() > MAX_IMAGE_SIZE) {
				return JSONResult.errorException("Uploaded file size exceed server's limit (10MB)");
			}
			String fileName = file.getOriginalFilename();
			if (StringUtils.isNotBlank(fileName)) {
				// 获取文件后缀
				String[] strList = fileName.split("\\.");
				String newFileName = order + "." + strList[strList.length-1];	// 把顺序 order.原后缀 作为文件名
				// 保存到数据库中的相对路径
				String uploadPathDB = resourceService.uploadImg(file);
				
				Integer imageOrder = Integer.valueOf(order);

				ArticleImage articleImage = new ArticleImage();
				articleImage.setImagePath(uploadPathDB);
				articleImage.setArticleId(articleId);
				articleImage.setImageOrder(imageOrder);
				articleService.saveArticleImages(articleImage);
				
				return JSONResult.ok();
			}else {
				return JSONResult.errorMsg("File name is blank");
			}
		}else {
			return JSONResult.errorMsg("Upload error");
		}
	}

	
	/**
	 * 根据热度查询文章
	 * @param page
	 * @param pageSize
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "Get the top 10 hot article")
	@PostMapping("/getHotTop10")
	public JSONResult getHotTop10(Integer page, Integer pageSize, String userId) throws Exception {

		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		
		PagedResult result = articleService.getArticleByPopularity(page, pageSize, userId);
//		List<ArticleVO> list = articleService.getTop3ByPopularity(userId);
		return JSONResult.ok(result);
	}
	
	@PostMapping("/getTagsList")
	public JSONResult getTagsList() {
		return JSONResult.ok(tagsService.getTagsList());
	}
	
	@ApiOperation(value = "查询某人收藏的文章", notes = "查看他人时只能查看status为1的, 查询自己时,可显示所有status")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "Integer", paramType = "form"),
		@ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form"),
		@ApiImplicitParam(name = "targetId", value = "目标查询者id", required = true, dataType = "String", paramType = "form")
	})
	@PostMapping("/queryCollectArticle")
	public JSONResult queryCollectArticle(Integer page, Integer pageSize, String userId, String targetId) {
		
		if(page == null) {
			page = 1;
		}
		if(pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		
		// 查询targetId收藏状态为1的文章
		PagedResult result = articleService.queryCollectArticle(page, pageSize, userId, targetId);
		
		return JSONResult.ok(result);
		
	}
	
}

package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.Longarticle;
import com.nuoquan.utils.MyMapper;

public interface LongarticleMapper extends MyMapper<Longarticle> {

	/**
	 * @Description: 对文章喜欢的数量进行累加
	 * @param articleId
	 */
	public void addLikeCount(String articleId);

	/**
	 * @Description: 对文章喜欢的数量进行累减
	 * @param articleId
	 */
	public void reduceLikeCount(String articleId);

	/**
	 * @Description: 对文章收藏的数量进行累加
	 * @param articleId
	 */
	public void addCollectCount(String articleId);

	/**
	 * @Description: 对文章收藏的数量进行累减
	 * @param articleId
	 */
	public void reduceCollectCount(String articleId);

	/*
	 * 增加文章的评论数
	 */
	public void addCommentCount(String articleId);

	/**
	 * 浏览量+1
	 * @param articleId
	 */
	public void addViewCount(String articleId);
}
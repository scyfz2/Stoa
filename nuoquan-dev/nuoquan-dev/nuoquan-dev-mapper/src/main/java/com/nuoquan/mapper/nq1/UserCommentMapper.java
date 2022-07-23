package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.UserComment;
import com.nuoquan.utils.MyMapper;

public interface UserCommentMapper extends MyMapper<UserComment> {
    /**
     * @Description: 对评论喜欢的数量进行累加
     * @param commentId
     */
    public void addLikeCount(String commentId);

    /**
     * @description: 对评论喜欢的数量进行累减
     * @param commentId
     */
    public void reduceLikeCount(String commentId);

    /**
     * @description: 对评论的评论的数量进行累加
     * @param commentId
     */
    public void addCommentCount(String commentId);
}
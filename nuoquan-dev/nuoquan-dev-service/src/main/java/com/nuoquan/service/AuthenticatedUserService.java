package com.nuoquan.service;

import com.nuoquan.pojo.AuthenticatedUser;
import com.nuoquan.pojo.vo.AuthenticatedUserVO;
import com.nuoquan.utils.PagedResult;

public interface AuthenticatedUserService {

    /**
     * 查询全部认证用户
     */
    public PagedResult list(Integer page, Integer pageSize);

    /**
     * 分页根据类别查询认证用户
     */
    public PagedResult listByType(Integer page, Integer pageSize, Integer type);

    /**
     * 按 userId 获取用户
     * @param userId
     * @return
     */
    public AuthenticatedUserVO getAuthUserById(String userId);

    /**
     * 按 userId 获取用户是否认证
     * @param userId
     * @return
     */
    public boolean checkUserIsAuth(String userId);

    /**
     * 使用email对用户进行认证
     * @return
     */
    public String authenticateByEmail(AuthenticatedUser authenticatedUser);

    /**
     * 取消某用户的认证
     * @param id
     */
    public void cancelAuthenticationById(String id);
//
//    /**
//     * 通过用户Id取消某用户的认证
//     * @param userId
//     */
//    public void cancelAuthenticationByUserId(String userId);
}

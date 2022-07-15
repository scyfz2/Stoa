package com.nuoquan.service;

import com.nuoquan.pojo.Article;
import com.nuoquan.pojo.ArticleImage;
import com.nuoquan.pojo.Organization;
import com.nuoquan.pojo.OrganizationImage;
import com.nuoquan.pojo.vo.OrganizationVO;
import com.nuoquan.utils.PagedResult;
import java.util.Date;

public interface OrganizationService {
    // 列出全部可显示的组织
    PagedResult queryOrganization(Integer page, Integer pageSize, String userId);

    // 伪删除组织，使组织status=0(Unreadable)
    void pseudoDeleteOrganization(String organizationId);

    // 伪删除组织图片，使组织status=0(Unreadable)
    int pseudoDeleteOrganizationImg(String organizationId, Integer order);

    // 根据组织id查询组织
    OrganizationVO getOrganizationById(String id);

    // 根据组织图片id查询组织图片
    OrganizationImage getOrganizationImgById(String id);

    // 将组织信息存入数据库
    String saveOrganization(Organization organization);

    // 保存组织图片
    void saveOrganizationImages(OrganizationImage organizationImage);
}

package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.ArticleImage;
import com.nuoquan.pojo.OrganizationImage;
import com.nuoquan.utils.MyMapper;

import java.util.List;

public interface OrganizationImageMapper extends MyMapper<OrganizationImage> {

    public List<OrganizationImage> getOrganizationImage(String articleId);

}

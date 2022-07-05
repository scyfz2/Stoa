package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.Organization;
import com.nuoquan.pojo.vo.OrganizationVO;
import com.nuoquan.utils.MyMapper;

import java.util.List;

public interface OrganizationMapper extends MyMapper<Organization> {

    // 获取所有状态为可显示的组织(status==1)
    public List<OrganizationVO> queryOrganization();
}

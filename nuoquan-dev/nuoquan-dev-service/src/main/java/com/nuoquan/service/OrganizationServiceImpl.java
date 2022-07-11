package com.nuoquan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.enums.StatusEnum;
import com.nuoquan.mapper.nq1.OrganizationImageMapper;
import com.nuoquan.mapper.nq1.OrganizationMapper;
import com.nuoquan.pojo.Organization;
import com.nuoquan.pojo.OrganizationImage;
import com.nuoquan.pojo.vo.OrganizationVO;
import com.nuoquan.utils.PageUtils;
import com.nuoquan.utils.PagedResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    private Sid sid;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private OrganizationImageMapper organizationImageMapper;

    //@Transactional(propagation = Propagation.SUPPORTS)
    public OrganizationVO addOrganizationImage(OrganizationVO organizationVO) {
        List<OrganizationImage> images = organizationImageMapper.getOrganizationImage(organizationVO.getId());
        //为图片url添加前缀
        for (OrganizationImage image : images) {
            image.setImagePath(resourceService.composeUrl(image.getImagePath()));
        }
        // 添加图片列表
        organizationVO.setImgList(images);
        return organizationVO;
    }

    // 将Organization转换为OrganizationVO 并为组织添加VO属性
    private OrganizationVO composeOrganizationVO(Organization organization) {
        OrganizationVO organizationVO = new OrganizationVO();
        BeanUtils.copyProperties(organization, organizationVO);
        return composeOrganizationVO(organizationVO);
    }

    // 为组织添加VO属性
    private OrganizationVO composeOrganizationVO(OrganizationVO organizationVO) {
        // 添加图片列表
        organizationVO = addOrganizationImage(organizationVO);
        organizationVO.setLogoPath(resourceService.composeUrl(organizationVO.getLogoPath()));
        organizationVO.getImgList();
        return organizationVO;
    }

    // 列出全部可显示的组织
    @Override
    public PagedResult queryOrganization(Integer page, Integer pageSize, String userId){
        Example organizationExample = new Example(Organization.class);
        // 在这些组织中找到状态为可读的组织
        Example.Criteria statusCriteria = organizationExample.createCriteria();
        statusCriteria.andEqualTo("status", StatusEnum.READABLE.type);
        organizationExample.and(statusCriteria);
        organizationExample.setOrderByClause("id desc");

        PageHelper.startPage(page, pageSize);
        List<Organization> list = organizationMapper.selectByExample(organizationExample);
        PageInfo<Organization> pageInfo = new PageInfo<>(list);
        PageInfo<OrganizationVO> pageInfoVO = PageUtils.PageInfo2PageInfoVo(pageInfo);

        // 组装VO
        List<OrganizationVO> listVO = new ArrayList<>();
        for (Organization c : list) {
            listVO.add(composeOrganizationVO(c));
        }
        pageInfoVO.setList(listVO);

        //为最终返回对象 pagedResult 添加属性
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(pageInfoVO.getPageNum());
        pagedResult.setTotal(pageInfoVO.getPages());
        pagedResult.setRows(pageInfoVO.getList());
        pagedResult.setRecords(pageInfoVO.getTotal());

        return pagedResult;
    }

    // 伪删除组织，使组织status=0(Unreadable)
    @Override
    public void	pseudoDeleteOrganization(String organizationId) {
        Example example = new Example(Organization.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", organizationId);
        Organization c = new Organization();
        c.setStatus(StatusEnum.DELETED.type);
        organizationMapper.updateByExampleSelective(c, example);
    }

    @Override
    public int pseudoDeleteOrganizationImg(String organizationId, Integer imageOrder){
        int flag = 0; // 若无此order图片，flag = 0
//        Example example = new Example(OrganizationImage.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", organizationId);

        OrganizationImage j = organizationImageMapper.getOrganizationImageByIdAndOrder(organizationId, imageOrder);
        if (j != null) {
            if (j.getStatus() != 0) {
                j.setStatus(StatusEnum.DELETED.type);
                organizationImageMapper.updateStatusToUnreadable(organizationId, imageOrder);
                flag = 1;
            }
        }
        return flag;
    }

    // 根据组织id查询组织
    @Override
    public OrganizationVO getOrganizationById(String id){
        Organization organization = organizationMapper.selectByPrimaryKey(id);
        OrganizationVO organizationVO = composeOrganizationVO(organization);
        return organizationVO;
    }

    @Override
    public OrganizationImage getOrganizationImgById(String id){
       return null;
    }

    // 将组织信息存入数据库
    @Override
    public String saveOrganization(Organization organization) {
        String id = sid.nextShort();
        organization.setId(id);
        organizationMapper.insertSelective(organization);
        return id;
    }

    // 将图片存入数据库
    @Override
    public void saveOrganizationImages(OrganizationImage organizationImage) {
        String id = sid.nextShort();
        organizationImage.setId(id);
        organizationImageMapper.insertSelective(organizationImage);
    }


}

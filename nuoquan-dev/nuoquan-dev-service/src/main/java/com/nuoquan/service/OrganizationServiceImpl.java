package com.nuoquan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.enums.StatusEnum;
import com.nuoquan.mapper.nq1.OrganizationImageMapper;
import com.nuoquan.mapper.nq1.OrganizationMapper;
import com.nuoquan.pojo.Organization;
import com.nuoquan.pojo.OrganizationImage;
import com.nuoquan.pojo.vo.OrganizationVO;
import com.nuoquan.utils.PagedResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
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
    private OrganizationVO composeCompanyVO(Organization organization) {
        OrganizationVO organizationVO = new OrganizationVO();
        BeanUtils.copyProperties(organization, organizationVO);
        return composeCompanyVO(organizationVO);
    }

    // 为组织添加VO属性
    private OrganizationVO composeCompanyVO(OrganizationVO organizationVO) {
        // 添加图片列表
        organizationVO = addOrganizationImage(organizationVO);
        organizationVO.setLogoPath(resourceService.composeUrl(organizationVO.getLogoPath()));
        organizationVO.getImgList();
        return organizationVO;
    }

    // 列出全部可显示的组织
    @Override
    public PagedResult queryOrganization(Integer page, Integer pageSize, String userId){
        PageHelper.startPage(page, pageSize);
        List<OrganizationVO> list = organizationMapper.queryOrganization();

        // 组装VO
        for (OrganizationVO j : list) {
            j = composeCompanyVO(j);
        }

        PageInfo<OrganizationVO> pageList = new PageInfo<>(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

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
    public int pseudoDeleteOrganizationImg(String organizationId, Integer order){
        int flag = 0;
        Example example = new Example(OrganizationImage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", organizationId);

        OrganizationVO organizationVO = getOrganizationById(organizationId);
        List<OrganizationImage> list = organizationVO.getImgList(); // 获得此组织的所有图片
        for (OrganizationImage j : list){
            if (order == j.getImageOrder()){
                j.setStatus(StatusEnum.DELETED.type);
                organizationImageMapper.updateByExampleSelective(j, example);
                flag = 1;
            }
        }
        return flag;
    }

    // 根据组织id查询组织
    @Override
    public OrganizationVO getOrganizationById(String id){
        Organization organization = organizationMapper.selectByPrimaryKey(id);
        OrganizationVO organizationVO = composeCompanyVO(organization);
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

    // 保存组织图片
    @Override
    public void saveOrganizationImages(OrganizationImage organizationImage) {
        String id = sid.nextShort();
        organizationImage.setId(id);
        organizationImageMapper.insertSelective(organizationImage);
    }


}

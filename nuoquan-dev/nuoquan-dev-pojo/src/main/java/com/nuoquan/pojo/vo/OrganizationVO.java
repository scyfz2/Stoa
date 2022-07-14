package com.nuoquan.pojo.vo;

import com.nuoquan.pojo.ArticleImage;
import com.nuoquan.pojo.OrganizationImage;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

public class OrganizationVO {
    private String id;

    // 组织名称
    private String name;

    // 组织规模
    private String scale;

    // 组织简介
    private String intro;

    // 组织招生人数
    private Integer recruitmentNum;

    // 组织招生要求
    private String requirement;

    // 组织logo
    private String logoPath;

    // 组织公众号或推文链接
    private String officialAccountLink;

    // 后台创建时间
    private Date createDate;

    // 0:unreadable/1:readable/2:checking
    private Integer status;

    // 组织图片列表
    private List<OrganizationImage> imgList;

    public String getOfficialAccountLink() {
        return officialAccountLink;
    }

    public void setOfficialAccountLink(String officialAccountLink) {
        this.officialAccountLink = officialAccountLink;
    }

    public Integer getStatus() {
        return status;
    }

    public List<OrganizationImage> getImgList() {
        return imgList;
    }

    public void setImgList(List<OrganizationImage> imgList) {
        this.imgList = imgList;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getRecruitmentNum() {
        return recruitmentNum;
    }

    public void setRecruitmentNum(Integer recruitmentNum) {
        this.recruitmentNum = recruitmentNum;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

}

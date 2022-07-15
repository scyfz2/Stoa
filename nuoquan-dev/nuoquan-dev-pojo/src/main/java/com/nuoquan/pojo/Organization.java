package com.nuoquan.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "organization")
public class Organization {
    @Id
    private String id;

    // 组织名称
    @Column(name = "name")
    private String name;

    // 组织规模
    @Column(name = "scale")
    private String scale;

    // 组织简介
    @Column(name = "intro")
    private String intro;

    // 组织招生人数
    @Column(name = "recruitment_num")
    private Integer recruitmentNum;

    // 组织招生要求
    @Column(name = "requirement")
    private String requirement;

    // 组织logo
    @Column(name = "logo_path")
    private String logoPath;

    // 组织公众号或推文链接
    @Column(name = "official_account_Link")
    private String officialAccountsLink;

    // 后台创建时间
    @Column(name = "create_date")
    private Date createDate;

    // 0:unreadable/1:readable/2:checking
    @Column(name = "status")
    private Integer status;

    public String getOfficialAccountsLink() {
        return officialAccountsLink;
    }

    public void setOfficialAccountsLink(String officialAccountsLink) {
        this.officialAccountsLink = officialAccountsLink;
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

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

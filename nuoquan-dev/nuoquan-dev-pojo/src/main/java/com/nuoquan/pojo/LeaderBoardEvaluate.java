package com.nuoquan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModelProperty;

public class LeaderBoardEvaluate implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long              id;

    @ApiModelProperty(value = "榜单对象 ID")
    private Long              leaderBoardObjectId;

    @ApiModelProperty(value = "用户 ID")
    private String            userId;

    @ApiModelProperty(value = "评价分数")
    private BigDecimal        star;

    @ApiModelProperty(value = "评价内容")
    private String            evaluateDesc;

    @ApiModelProperty(value = "点亮数")
    private Integer           starNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间")
    private Date              sendDate;

    @ApiModelProperty(value = "创建人")
    private String            createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date              createTime;

    @ApiModelProperty(value = "修改人")
    private String            updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date              updateTime;

    @ApiModelProperty(value = "删除标识")
    private Integer           delFlag;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("leaderBoardObjectId")
    public Long getLeaderBoardObjectId() {
        return leaderBoardObjectId;
    }

    public void setLeaderBoardObjectId(Long leaderBoardObjectId) {
        this.leaderBoardObjectId = leaderBoardObjectId;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("star")
    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    @JsonProperty("evaluateDesc")
    public String getEvaluateDesc() {
        return evaluateDesc;
    }

    public void setEvaluateDesc(String evaluateDesc) {
        this.evaluateDesc = evaluateDesc;
    }

    @JsonProperty("starNum")
    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    @JsonProperty("sendDate")
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @JsonProperty("createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonProperty("createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("updateBy")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @JsonProperty("updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("delFlag")
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public LeaderBoardEvaluate(Long id, Long leaderBoardObjectId, String userId, BigDecimal star, String evaluateDesc, Integer starNum, Date sendDate, String createBy,
                               Date createTime, String updateBy, Date updateTime, Integer delFlag) {

        this.id = id;

        this.leaderBoardObjectId = leaderBoardObjectId;

        this.userId = userId;

        this.star = star;

        this.evaluateDesc = evaluateDesc;

        this.starNum = starNum;

        this.sendDate = sendDate;

        this.createBy = createBy;

        this.createTime = createTime;

        this.updateBy = updateBy;

        this.updateTime = updateTime;

        this.delFlag = delFlag;

    }

    public LeaderBoardEvaluate() {
        super();
    }

    public String dateToStringConvert(Date date) {
        if (date != null) {
            return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        }
        return "";
    }

}

package com.nuoquan.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class RankingList implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private Long              id;

    @ApiModelProperty(value = "排行日期")
    private String            date;

    @ApiModelProperty(value = "用户Id")
    private String            userId;

    @ApiModelProperty(value = "排行")
    private Integer           sort;

    @ApiModelProperty(value = "类型 1 影响力 2 功德")
    private String            type;

    @ApiModelProperty(value = "值")
    private Integer           value;

    @ApiModelProperty(value = "")
    private Character         isDeleted;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("isDeleted")
    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    public RankingList(Long id, String date, String userId, Integer sort, String type, Integer value,
                       Character isDeleted) {

        this.id = id;

        this.date = date;

        this.userId = userId;

        this.sort = sort;

        this.type = type;

        this.value = value;

        this.isDeleted = isDeleted;

    }

    public RankingList() {
        super();
    }

}

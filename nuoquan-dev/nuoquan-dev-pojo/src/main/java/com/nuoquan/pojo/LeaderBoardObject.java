package com.nuoquan.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.math.BigDecimal;
import java.util.Date;

public class LeaderBoardObject implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "榜单对象名")
	private String name;
	
	@ApiModelProperty(value = "榜单 ID")
	private String leaderBoardId;
	
	@ApiModelProperty(value = "榜单背景图片0")
	private String imgUrl0;
	
	@ApiModelProperty(value = "榜单背景图片1")
	private String imgUrl1;
	
	@ApiModelProperty(value = "榜单背景图片2")
	private String imgUrl2;
	
	@ApiModelProperty(value = "分区类型 可以多选")
	private String tag;
	
	@ApiModelProperty(value = "分数 最多一位小数")
	private BigDecimal star;
	
	@ApiModelProperty(value = "评分人数")
	private Integer evaluateNums;
	
	@ApiModelProperty(value = "榜单简介")
	private String leaderBoardDesc;
	
	@ApiModelProperty(value = "审核状态")
	private String status;
	
	@ApiModelProperty(value = "创建人")
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	
	@ApiModelProperty(value = "修改人")
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	
	@ApiModelProperty(value = "删除标识")
	private Integer delFlag;
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name =  name;
	}
	@JsonProperty("leaderBoardId")
	public String getLeaderBoardId() {
		return leaderBoardId;
	}

	public void setLeaderBoardId(String leaderBoardId) {
		this.leaderBoardId =  leaderBoardId;
	}
	@JsonProperty("imgUrl0")
	public String getImgUrl0() {
		return imgUrl0;
	}

	public void setImgUrl0(String imgUrl0) {
		this.imgUrl0 =  imgUrl0;
	}
	@JsonProperty("imgUrl1")
	public String getImgUrl1() {
		return imgUrl1;
	}

	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 =  imgUrl1;
	}
	@JsonProperty("imgUrl2")
	public String getImgUrl2() {
		return imgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 =  imgUrl2;
	}
	@JsonProperty("tag")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag =  tag;
	}
	@JsonProperty("star")
	public BigDecimal getStar() {
		return star;
	}

	public void setStar(BigDecimal star) {
		this.star =  star;
	}
	@JsonProperty("evaluateNums")
	public Integer getEvaluateNums() {
		return evaluateNums;
	}

	public void setEvaluateNums(Integer evaluateNums) {
		this.evaluateNums =  evaluateNums;
	}
	@JsonProperty("leaderBoardDesc")
	public String getLeaderBoardDesc() {
		return leaderBoardDesc;
	}

	public void setLeaderBoardDesc(String leaderBoardDesc) {
		this.leaderBoardDesc =  leaderBoardDesc;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status =  status;
	}
	@JsonProperty("createBy")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy =  createBy;
	}
	@JsonProperty("createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime =  createTime;
	}
	@JsonProperty("updateBy")
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy =  updateBy;
	}
	@JsonProperty("updateTime")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime =  updateTime;
	}
	@JsonProperty("delFlag")
	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag =  delFlag;
	}


	public LeaderBoardObject(Long id,String name,String leaderBoardId,String imgUrl0,String imgUrl1,String imgUrl2,String tag,BigDecimal star,Integer evaluateNums,String leaderBoardDesc,String status,String createBy,Date createTime,String updateBy,Date updateTime,Integer delFlag) {
		
		this.id = id;
		
		this.name = name;
		
		this.leaderBoardId = leaderBoardId;
		
		this.imgUrl0 = imgUrl0;
		
		this.imgUrl1 = imgUrl1;
		
		this.imgUrl2 = imgUrl2;
		
		this.tag = tag;
		
		this.star = star;
		
		this.evaluateNums = evaluateNums;
		
		this.leaderBoardDesc = leaderBoardDesc;
		
		this.status = status;
		
		this.createBy = createBy;
		
		this.createTime = createTime;
		
		this.updateBy = updateBy;
		
		this.updateTime = updateTime;
		
		this.delFlag = delFlag;
		
	}

	public LeaderBoardObject() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}
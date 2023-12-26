package com.nuoquan.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.math.BigDecimal;
import java.util.Date;

public class LeaderBoardTag implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "tag 名")
	private String tagName;
	
	@ApiModelProperty(value = "扩展字段")
	private String extend1;
	
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
	@JsonProperty("tagName")
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName =  tagName;
	}
	@JsonProperty("extend1")
	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 =  extend1;
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


	public LeaderBoardTag(Long id,String tagName,String extend1,String createBy,Date createTime,String updateBy,Date updateTime,Integer delFlag) {
		
		this.id = id;
		
		this.tagName = tagName;
		
		this.extend1 = extend1;
		
		this.createBy = createBy;
		
		this.createTime = createTime;
		
		this.updateBy = updateBy;
		
		this.updateTime = updateTime;
		
		this.delFlag = delFlag;
		
	}

	public LeaderBoardTag() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}
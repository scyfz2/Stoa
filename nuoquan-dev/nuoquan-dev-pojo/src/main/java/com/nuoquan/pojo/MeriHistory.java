package com.nuoquan.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class MeriHistory implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private Integer id;
	
	@ApiModelProperty(value = "")
	private String userId;

	@ApiModelProperty(value = "领取时间")
	private String date;
	
	@ApiModelProperty(value = "领取值")
	private Integer merit;
	
	@ApiModelProperty(value = "")
	private Character isDeleted;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId =  userId;
	}
	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date =  date;
	}
	@JsonProperty("merit")
	public Integer getMerit() {
		return merit;
	}

	public void setMerit(Integer merit) {
		this.merit =  merit;
	}
	@JsonProperty("isDeleted")
	public Character getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Character isDeleted) {
		this.isDeleted =  isDeleted;
	}


	public MeriHistory(Integer id,String userId,String date,Integer merit,Character isDeleted) {
		
		this.id = id;
		
		this.userId = userId;
		
		this.date = date;
		
		this.merit = merit;
		
		this.isDeleted = isDeleted;
		
	}

	public MeriHistory() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}
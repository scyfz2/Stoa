package com.nuoquan.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LotteryHistory implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private Integer id;
	
	@ApiModelProperty(value = "奖品Id")
	private Integer lotteryId;
	
	@ApiModelProperty(value = "奖品编号")
	private Integer lotteryNo;

	@ApiModelProperty(value = "奖品名称")
	private String lotteryName;
	
	@ApiModelProperty(value = "奖品内容")
	private String lotteryContent;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "抽奖日期")
	private Date lotteryDate;
	
	@ApiModelProperty(value = "用户Id")
	private String userId;
	
	@ApiModelProperty(value = "")
	private Character isDeleted;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("lotteryId")
	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId =  lotteryId;
	}
	@JsonProperty("lotteryNo")
	public Integer getLotteryNo() {
		return lotteryNo;
	}

	public void setLotteryNo(Integer lotteryNo) {
		this.lotteryNo =  lotteryNo;
	}
	@JsonProperty("lotteryContent")
	public String getLotteryContent() {
		return lotteryContent;
	}


	@JsonProperty("lotteryName")
	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public void setLotteryContent(String lotteryContent) {
		this.lotteryContent =  lotteryContent;
	}
	@JsonProperty("lotteryDate")
	public Date getLotteryDate() {
		return lotteryDate;
	}

	public void setLotteryDate(Date lotteryDate) {
		this.lotteryDate =  lotteryDate;
	}
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId =  userId;
	}
	@JsonProperty("isDeleted")
	public Character getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Character isDeleted) {
		this.isDeleted =  isDeleted;
	}


	public LotteryHistory(Integer id,Integer lotteryId,Integer lotteryNo,String lotteryContent,Date lotteryDate,String userId,Character isDeleted) {
		
		this.id = id;
		
		this.lotteryId = lotteryId;
		
		this.lotteryNo = lotteryNo;
		
		this.lotteryContent = lotteryContent;
		
		this.lotteryDate = lotteryDate;
		
		this.userId = userId;
		
		this.isDeleted = isDeleted;
		
	}

	public LotteryHistory() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}
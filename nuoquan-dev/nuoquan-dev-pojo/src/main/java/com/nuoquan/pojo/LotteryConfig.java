package com.nuoquan.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class LotteryConfig implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private Integer id;
	
	@ApiModelProperty(value = "奖品名称")
	private String lotteryName;
	
	@ApiModelProperty(value = "奖品内容")
	private String lotteryContent;
	
	@ApiModelProperty(value = "奖品 icon 地址")
	private String imageUrl;
	
	@ApiModelProperty(value = "中奖概率设置")
	private Integer threshold;
	
	@ApiModelProperty(value = "功德值范围 ")
	private Integer meritStart;
	
	@ApiModelProperty(value = "功德值范围")
	private Integer meritEnd;
	
	@ApiModelProperty(value = "")
	private Character isDeleted;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("lotteryName")
	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName =  lotteryName;
	}
	@JsonProperty("lotteryContent")
	public String getLotteryContent() {
		return lotteryContent;
	}

	public void setLotteryContent(String lotteryContent) {
		this.lotteryContent =  lotteryContent;
	}
	@JsonProperty("imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl =  imageUrl;
	}
	@JsonProperty("threshold")
	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold =  threshold;
	}
	@JsonProperty("meritStart")
	public Integer getMeritStart() {
		return meritStart;
	}

	public void setMeritStart(Integer meritStart) {
		this.meritStart =  meritStart;
	}
	@JsonProperty("meritEnd")
	public Integer getMeritEnd() {
		return meritEnd;
	}

	public void setMeritEnd(Integer meritEnd) {
		this.meritEnd =  meritEnd;
	}
	@JsonProperty("isDeleted")
	public Character getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Character isDeleted) {
		this.isDeleted =  isDeleted;
	}


	public LotteryConfig(Integer id,String lotteryName,String lotteryContent,String imageUrl,Integer threshold,Integer meritStart,Integer meritEnd,Character isDeleted) {
		
		this.id = id;
		
		this.lotteryName = lotteryName;
		
		this.lotteryContent = lotteryContent;
		
		this.imageUrl = imageUrl;
		
		this.threshold = threshold;
		
		this.meritStart = meritStart;
		
		this.meritEnd = meritEnd;
		
		this.isDeleted = isDeleted;
		
	}

	public LotteryConfig() {
	    super();
	}

	

}
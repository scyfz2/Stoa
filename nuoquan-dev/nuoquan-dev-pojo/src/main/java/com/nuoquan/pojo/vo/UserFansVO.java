package com.nuoquan.pojo.vo;

import javax.persistence.*;

public class UserFansVO {
	
	private String id; 				// 用户id
    private String nickname;		// 用户昵称
    private String faceImg; 		// 大头像
    private String faceImgThumb;	// 小头像
    private Byte gender;			// 性别
    private boolean isFollow;		// 是否关注该用户
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFaceImg() {
		return faceImg;
	}
	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}
	public String getFaceImgThumb() {
		return faceImgThumb;
	}
	public void setFaceImgThumb(String faceImgThumb) {
		this.faceImgThumb = faceImgThumb;
	}
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public boolean isFollow() {
		return isFollow;
	}
	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
}
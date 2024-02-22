package com.nuoquan.pojo.vo;

import com.nuoquan.pojo.LeaderBoardEvaluate;

/**
 * LeaderBoardEvaluateVO
 *
 * @author xxdd
 * @date 2024-01-14 20:10
 */
public class LeaderBoardEvaluateVO extends LeaderBoardEvaluate {
    private Boolean starFlag;
    private String  nickname;
    private String  faceImg;

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

    public Boolean getStarFlag() {
        return starFlag;
    }

    public void setStarFlag(Boolean starFlag) {
        this.starFlag = starFlag;
    }
}

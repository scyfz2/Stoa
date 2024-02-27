package com.nuoquan.pojo.vo;

import java.util.List;
import java.util.Map;

import com.nuoquan.pojo.LeaderBoardObject;

/**
 * LeaderBoardObjectVO
 *
 * @author xxdd
 * @date 2024-01-04 22:42
 */
public class LeaderBoardObjectVO extends LeaderBoardObject {
    private String               leaderBoardName;

    private Boolean              evaluateFlag;
    private String              createByNickname;

    public String getCreateByNickname() {
        return createByNickname;
    }

    public void setCreateByNickname(String createByNickname) {
        this.createByNickname = createByNickname;
    }

    private Map<Integer, String> starMap;

    public Map<Integer, String> getStarMap() {
        return starMap;
    }

    public void setStarMap(Map<Integer, String> starMap) {
        this.starMap = starMap;
    }

    public Boolean getEvaluateFlag() {
        return evaluateFlag;
    }

    public void setEvaluateFlag(Boolean evaluateFlag) {
        this.evaluateFlag = evaluateFlag;
    }

    private List<LeaderBoardEvaluateVO> leaderBoardEvaluateList;

    public String getLeaderBoardName() {
        return leaderBoardName;
    }

    public void setLeaderBoardName(String leaderBoardName) {
        this.leaderBoardName = leaderBoardName;
    }

    public List<LeaderBoardEvaluateVO> getLeaderBoardEvaluateList() {
        return leaderBoardEvaluateList;
    }

    public void setLeaderBoardEvaluateList(List<LeaderBoardEvaluateVO> leaderBoardEvaluateList) {
        this.leaderBoardEvaluateList = leaderBoardEvaluateList;
    }
}

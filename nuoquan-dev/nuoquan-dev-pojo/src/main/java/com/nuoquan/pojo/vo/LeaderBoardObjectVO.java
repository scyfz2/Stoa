package com.nuoquan.pojo.vo;

import java.util.List;

import com.nuoquan.pojo.LeaderBoardObject;

/**
 * LeaderBoardObjectVO
 *
 * @author xxdd
 * @date 2024-01-04 22:42
 */
public class LeaderBoardObjectVO extends LeaderBoardObject {
    private String                      leaderBoardName;

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

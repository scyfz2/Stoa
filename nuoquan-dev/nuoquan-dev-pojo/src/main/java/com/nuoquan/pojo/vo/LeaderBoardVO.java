package com.nuoquan.pojo.vo;

import java.util.List;

import com.nuoquan.pojo.LeaderBoard;

/**
 * LeaderBoardVO
 *
 * @author xxdd
 * @date 2024-01-14 20:09
 */
public class LeaderBoardVO extends LeaderBoard {

    private List<LeaderBoardObjectVO> leaderBoardObjectList;

    public List<LeaderBoardObjectVO> getLeaderBoardObjectList() {
        return leaderBoardObjectList;
    }

    public void setLeaderBoardObjectList(List<LeaderBoardObjectVO> leaderBoardObjectList) {
        this.leaderBoardObjectList = leaderBoardObjectList;
    }
}

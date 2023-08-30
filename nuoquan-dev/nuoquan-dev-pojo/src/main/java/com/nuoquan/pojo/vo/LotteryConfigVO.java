package com.nuoquan.pojo.vo;
import com.nuoquan.pojo.LotteryConfig;
/**
 * LotteryConfigVO
 *
 * @author xxdd
 * @date 2023-08-30 22:38
 */
public class LotteryConfigVO extends LotteryConfig{

    /**
     * 0 是实物 1 是虚拟
     */
    private String prizeStatus;

    public String getPrizeStatus() {
        return prizeStatus;
    }

    public void setPrizeStatus(String prizeStatus) {
        this.prizeStatus = prizeStatus;
    }
}

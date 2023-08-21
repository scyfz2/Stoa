package com.nuoquan.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.core.util.RandomUtil;
import com.nuoquan.pojo.LotteryConfig;

/**
 * TestLuckDraw
 *
 * @author xxdd
 * @date 2023-08-11 09:41
 */
public class PrizeHelper {
//    public static void main(String[] args) {
//        List<Prize> prizeList = new ArrayList<>();
//        prizeList.add(new Prize(0, "奖品0", 800));
//        prizeList.add(new Prize(1, "奖品1", 100));
//        prizeList.add(new Prize(2, "奖品2", 100));
//        prizeList.add(new Prize(3, "奖品3", 0));
//        prizeList.add(new Prize(4, "奖品4", 0));
//
//        //进行一千次抽奖验证概率
//        List<Prize> lotteryResult = new ArrayList<>();
//        for (int i = 0; i <= 10000; i++) {
//            lotteryResult.add(lottery(prizeList));
//        }
//        Map<String, List<Prize>> collect = lotteryResult.stream()
//                .collect(Collectors.groupingBy(Prize::getName));
//        collect.forEach((k, v) -> System.out.println(k + " 被抽中 " + v.size() + " 次"));
//    }

    public static LotteryConfig prize(List<LotteryConfig> prizeList) {
        //按照权重从小到大排序奖品
        prizeList.sort(Comparator.comparingInt(LotteryConfig::getThreshold));

        //计算节点 节点的数量比奖品的数量多一个，即0
        List<Integer> nodeList = new ArrayList<>();
        //第一个节点为0
        nodeList.add(0);
        for (LotteryConfig prize : prizeList) {
            //每一个节点等于前一个节点+当前奖品的权重
            nodeList.add(nodeList.get(nodeList.size() - 1) + prize.getThreshold());
        }

        //生成 0-结束节点 的随机数
        int randomInt = RandomUtil.randomInt(0, nodeList.get(nodeList.size() - 1));

        //最终抽奖逻辑 此处需要从第二个节点开始遍历
        for (int i = 1; i < nodeList.size(); i++) {
            //本次节点
            Integer endNode = nodeList.get(i);
            //前一个节点
            Integer startNode = nodeList.get(i - 1);
            //若随机数大于等于前一个节点并且小于本节点，在prizeList中位于i-1位置的奖品为抽中奖品
            //Tip：比较大小时，左闭右开与左开右闭都可以，不影响整体概率
            if (randomInt >= startNode && randomInt < endNode) {
                return prizeList.get(i - 1);
            }
        }
        throw new RuntimeException("程序异常 生成的随机数不在任何奖品区间内");
    }
}


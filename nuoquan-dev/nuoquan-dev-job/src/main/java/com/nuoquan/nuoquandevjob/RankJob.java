package com.nuoquan.nuoquandevjob;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.nuoquan.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.RankingListExample;
import com.nuoquan.pojo.User;
import com.nuoquan.service.RankingListService;
import com.nuoquan.service.UserService;

import cn.hutool.core.date.DateUtil;

@Component
@ConditionalOnProperty(name = "nuoquan.job.enabled", havingValue = "true")
public class RankJob {

    @Autowired
    private UserService        userService;

    @Autowired
    private RankingListService rankingListService;
    Logger                     log = LoggerFactory.getLogger(RankJob.class);

//    @Scheduled(cron = "0 0/10 * * * ? ")
    @Scheduled(cron = "0 0 0 * * ?")
    public void test() {
        log.info("=====RankJob start=====");
        // 每天23:50 统计当日排行榜
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");

        RankingListExample example = new RankingListExample();
        example.createCriteria().andDateEqualTo(date).andTypeEqualTo("1");
        List<RankingList> rankingLists = rankingListService.selectByExample(example);
        if (!CollectionUtils.isEmpty(rankingLists)) {
            log.info("=====RankJob end already exists=====");
            return;
        }

        // 影响力排行榜
        List<User> reputation = userService.getUserRankingList("reputation");
        AtomicInteger i = new AtomicInteger(1);
        List<RankingList> reputationList = Optional.ofNullable(reputation).orElse(Lists.newArrayList()).stream()
                .map(x -> {
                    RankingList rank = new RankingList();
                    rank.setDate(date);
                    rank.setUserId(x.getId());
                    //(value = "类型 1 影响力 2 功德")
                    rank.setType("1");
                    rank.setSort(i.getAndIncrement());
                    rank.setValue(x.getReputation());
                    return rank;
                }).collect(Collectors.toList());
        reputationList.forEach(rankingListService::insertSelective);

        // 功德值排行榜
        List<User> merit = userService.getUserRankingList("merit");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        List<RankingList> meritList = Optional.ofNullable(merit).orElse(Lists.newArrayList()).stream().map(x -> {
            RankingList rank = new RankingList();
            rank.setDate(date);
            rank.setUserId(x.getId());
            //(value = "类型 1 影响力 2 功德")
            rank.setType("2");
            rank.setSort(atomicInteger.getAndIncrement());
            rank.setValue(x.getMerit());
            return rank;
        }).collect(Collectors.toList());
        meritList.forEach(rankingListService::insertSelective);

        log.info("=====RankJob end=====");

    }

}

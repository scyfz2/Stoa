package com.nuoquan.api;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.RankingListExample;
import com.nuoquan.pojo.User;
import com.nuoquan.pojo.vo.RankingListVO;
import com.nuoquan.pojo.vo.UserVO;
import com.nuoquan.service.RankingListService;
import com.nuoquan.service.UserService;
import com.nuoquan.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 抽奖 C 端接口
 * 
 * @ClassName: LotteryConfigController
 * @author fuce
 * @date 2023-08-19 22:47:40
 */
@Api(value = "排行榜接口")
@RestController
@RequestMapping("/rank")
public class RankApi extends BasicController {

    @Autowired
    private RankingListService rankingListService;

    @Autowired
    private UserService        userService;

    /**
     * @param date
     * @return
     */
    @ApiOperation(value = "获取排行", notes = "分页跳转")
    @GetMapping("/list")
    @ApiImplicitParams({ @ApiImplicitParam(name = "date", value = "日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "类型1 影响力 2 功德 ", required = true, dataType = "String") })
    public AjaxResult view(String date, String type) {

        if (StringUtils.isEmpty(date)) {
            // 功德 + 不传日期 = 总榜
            if ("2".equals(type)) {
                List<User> merit = userService.getUserRankingList("merit");
                AtomicInteger atomicInteger = new AtomicInteger(1);
                List<RankingListVO> meritList = Optional.ofNullable(merit).orElse(Lists.newArrayList()).stream()
                        .map(x -> {
                            RankingListVO rank = new RankingListVO();
                            rank.setDate(date);
                            rank.setUserId(x.getId());
                            //(value = "类型 1 影响力 2 功德")
                            rank.setType("2");
                            rank.setSort(atomicInteger.getAndIncrement());
                            rank.setValue(x.getMerit());
                            rank.setNickname(x.getNickname());
                            rank.setFaceImg(x.getFaceImg());
                            return rank;
                        }).collect(Collectors.toList());
                return AjaxResult.successData(200, meritList);
            }
            // 影响力 + 不传日期 = 总榜
            if ("1".equals(type)) {
                List<User> merit = userService.getUserRankingList("reputation");
                AtomicInteger atomicInteger = new AtomicInteger(1);
                List<RankingListVO> meritList = Optional.ofNullable(merit).orElse(Lists.newArrayList()).stream()
                        .map(x -> {
                            RankingListVO rank = new RankingListVO();
                            rank.setDate(date);
                            rank.setUserId(x.getId());
                            //(value = "类型 1 影响力 2 功德")
                            rank.setType("1");
                            rank.setSort(atomicInteger.getAndIncrement());
                            rank.setValue(x.getReputation());
                            rank.setNickname(x.getNickname());
                            rank.setFaceImg(x.getFaceImg());
                            return rank;
                        }).collect(Collectors.toList());
                return AjaxResult.successData(200, meritList);
            }
        }

        RankingListExample example = new RankingListExample();
        //2023-08-31
        example.createCriteria().andDateLike(date + "%").andTypeEqualTo(type);
        example.setOrderByClause("date DESC,sort asc limit 10");
        List<RankingList> rankingLists = rankingListService.selectByExample(example);
        // 获取排行榜
        List<RankingListVO> collect = Optional.ofNullable(rankingLists).orElse(Lists.newArrayList()).stream().map(x -> {
            RankingListVO rankingListVO = new RankingListVO();
            BeanUtils.copyProperties(x, rankingListVO);
            UserVO user = userService.getUserById(x.getUserId());
            rankingListVO.setNickname(user.getNickname());
            rankingListVO.setFaceImg(user.getFaceImg());
            return rankingListVO;
        }).collect(Collectors.toList());

        return AjaxResult.successData(200, collect);
    }

}

package com.nuoquan.api;

import java.util.Date;

import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.LotteryConfig;
import com.nuoquan.pojo.LotteryHistory;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.vo.UserVO;
import com.nuoquan.service.LotteryConfigService;
import com.nuoquan.service.LotteryHistoryService;
import com.nuoquan.service.UserService;
import com.nuoquan.util.CommonUtil;

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
@Api(value = "奖品配置表")
@RestController
@RequestMapping("/lottery")
public class LotteryApi extends BasicController {

    @Autowired
    private LotteryConfigService  lotteryConfigService;

    @Autowired
    private LotteryHistoryService lotteryHistoryService;

    @Autowired
    private UserService           userService;

    /**
     * @param userId
     * @return
     */
    @ApiOperation(value = "抽奖", notes = "分页跳转")
    @GetMapping("/getPrize")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form") })
    public AjaxResult view(String userId) {
        // 1. 查询功德值
        UserVO user = userService.getUserById(userId);
        if (user == null) {
            return AjaxResult.error(500, "用户不存在！");
        }

        // 2. 查询奖品 level
        Triple<Integer, Integer, Integer> prizeLevel = CommonUtil.getPrizeLevel(user.getMerit());
        if (prizeLevel == null) {
            return AjaxResult.error(500, "功德值过低，无法抽奖！");
        }

        // 3. 查询奖品
        TableparV2 tableparV2 = new TableparV2();
        tableparV2.setPage(1);
        tableparV2.setLimit(1000);
        PageInfo<LotteryConfig> page = lotteryConfigService.getLotteryByMerit(tableparV2, prizeLevel.getMiddle(),
                prizeLevel.getRight());

        if (page == null || CollectionUtils.isEmpty(page.getList())) {
            return AjaxResult.error(500, "奖品未配置！");
        }

        // 4. 抽奖
        LotteryConfig lotteryConfig = null;
        try {
            lotteryConfig = PrizeHelper.prize(page.getList());
            // 保存影响力或者功德值
            if (lotteryConfig.getLotteryName().contains("点影响力")) {
                userService.updateReputation(userId, CommonUtil.getValue(lotteryConfig.getLotteryName()), 1);
            }
            if (lotteryConfig.getLotteryName().contains("点功德")) {
                userService.updateMerit(userId, CommonUtil.getValue(lotteryConfig.getLotteryName()), 1);
            }
            LotteryHistory lotteryHistory = new LotteryHistory();
            lotteryHistory.setUserId(userId);
            lotteryHistory.setLotteryId(lotteryConfig.getId());
            lotteryHistory.setLotteryName(lotteryConfig.getLotteryName());
            lotteryHistory.setLotteryContent(lotteryConfig.getLotteryContent());
            lotteryHistory.setLotteryDate(new Date());
            lotteryHistoryService.insertSelective(lotteryHistory);
        } catch (Exception e) {
            return AjaxResult.error(500, "系统异常！");
        }
        return AjaxResult.successData(200, lotteryConfig);
    }

    @ApiOperation(value = "获取奖品列表", notes = "获取奖品列表")
    @GetMapping("/getPrizeList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form") })
    public AjaxResult getPrizeList(String userId) {

        // 1. 查询功德值
        UserVO user = userService.getUserById(userId);
        if (user == null) {
            return AjaxResult.error(500, "用户不存在！");
        }

        // 2. 查询奖品 level
        Triple<Integer, Integer, Integer> prizeLevel = CommonUtil.getPrizeLevel(user.getMerit());
        if (prizeLevel == null) {
            return AjaxResult.error(500, "功德值过低，无法抽奖！");
        }

        // 3. 查询奖品
        TableparV2 tableparV2 = new TableparV2();
        tableparV2.setPage(1);
        tableparV2.setLimit(30);
        PageInfo<LotteryConfig> page = lotteryConfigService.getLotteryByMerit(tableparV2, prizeLevel.getMiddle(),
                prizeLevel.getRight());

        return AjaxResult.successData(200, page.getList());
    }

    @ApiOperation(value = "获取获奖记录", notes = "获取奖品列表")
    @GetMapping("/getPrizeListHistory")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form") })
    public AjaxResult getPrizeListByUserId(String userId) {

        // 1. 查询奖品
        TableparV2 tableparV2 = new TableparV2();
        tableparV2.setPage(1);
        tableparV2.setLimit(30);
        LotteryHistory lotteryHistory = new LotteryHistory();
        lotteryHistory.setUserId(userId);
        PageInfo<LotteryHistory> page = lotteryHistoryService.list(tableparV2, lotteryHistory);

        if (page == null) {
            return AjaxResult.error(500, "奖品未配置！");
        }

        return AjaxResult.successData(200, page.getList());
    }

}

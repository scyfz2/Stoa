package com.nuoquan.api;

import java.util.Date;
import java.util.List;

import io.netty.buffer.ByteBufUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.MeriHistory;
import com.nuoquan.pojo.MeriHistoryExample;
import com.nuoquan.service.MeriHistoryService;
import com.nuoquan.service.UserService;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * UserApi
 *
 * @author xxdd
 * @date 2023-08-21 22:56
 */
@Api(value = "排行榜接口")
@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private MeriHistoryService meriHistoryService;

    @Autowired
    private UserService        userService;

    @ApiOperation(value = "领取功德", notes = "分页跳转")
    @PostMapping("/signIn")
    @ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "String") })
    public AjaxResult view(String userId) {

        // 1. 领取功德
        MeriHistoryExample historyExample = new MeriHistoryExample();
        String date = DateUtil.format(new Date(), "yyyy-MM-dd");
        historyExample.createCriteria().andUserIdEqualTo(userId).andDateEqualTo(date);
        List<MeriHistory> meriHistories = meriHistoryService.selectByExample(historyExample);
        if (CollectionUtil.isNotEmpty(meriHistories)) {
            return AjaxResult.successData(500, "用户已领取功德值！");
        }
        userService.updateMerit(userId, 10, 1);
        MeriHistory meriHistory = new MeriHistory();
        meriHistory.setUserId(userId);
        meriHistory.setDate(date);
        meriHistory.setMerit(10);
        meriHistory.setIsDeleted('0');
        meriHistoryService.insertSelective(meriHistory);
        return AjaxResult.successData(200, "领取成功");
    }





}

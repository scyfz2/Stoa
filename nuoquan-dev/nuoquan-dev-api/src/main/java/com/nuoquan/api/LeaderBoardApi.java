package com.nuoquan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.service.LeaderBoardService;
import com.nuoquan.service.UserService;

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
@RequestMapping("/leader/board")
public class LeaderBoardApi extends BasicController {

    @Autowired
    private LeaderBoardService leaderBoardService;

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

        return AjaxResult.successData(200, null);
    }

}

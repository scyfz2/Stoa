package com.nuoquan.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.MeriHistory;
import com.nuoquan.pojo.MeriHistoryExample;
import com.nuoquan.pojo.vo.UserVO;
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

    //    @Autowired
    //    @Qualifier("uniAppService")
    //    private WechatService      uniAppService;

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

    @ApiOperation(value = "根据 userId 获取用户信息", notes = "根据 userId 获取用户信息")
    @GetMapping("/getUniAppOpenId")
    @ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "String") })
    public AjaxResult getUniAppOpenId(String userId) {
        UserVO userVo = userService.getUserById(userId);
        return AjaxResult.successData(200, userVo);
    }

//    @PostMapping("/test")
//    public AjaxResult test(String userId) {
//        WxTemplateMsg wxTemplateMsg = new WxTemplateMsg();
//        wxTemplateMsg.setName1("123");
//        try {
//            uniAppService.sendTemplateMsg(0, "oDwsO5DI_i4GgK4l1knfdVy1OXGA", wxTemplateMsg);
//        } catch (WxErrorException e) {
//            throw new RuntimeException(e);
//        }
//        return AjaxResult.successData(200, "领取成功");
//    }
}

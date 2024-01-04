package com.nuoquan.api;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.nuoquan.admin.controller.FunctionUtils.doIf;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.*;
import com.nuoquan.service.*;
import com.nuoquan.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 排行榜接口
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
    private LeaderBoardService             leaderBoardService;

    @Autowired
    private LeaderBoardObjectService       leaderBoardObjectService;

    @Autowired
    private LeaderBoardTagService          leaderBoardTagService;

    @Autowired
    private LeaderBoardEvaluateService     leaderBoardEvaluateService;

    @Autowired
    private LeaderBoardEvaluateStarService leaderBoardEvaluateStarService;

    @Autowired
    private UserService                    userService;

    @ApiOperation(value = "获取TAG", notes = "获取TAG")
    @GetMapping("/tag/list")
    public AjaxResult tag() {
        List<LeaderBoardTag> tagList = leaderBoardTagService.selectByExample(null);
        return AjaxResult.successData(200, tagList);
    }

    @ApiOperation(value = "获取排行榜", notes = "获取排行榜")
    @GetMapping("/list")
    public AjaxResult view(Integer page, Integer pageSize, String tag) {
        startPage(page, pageSize);
        LeaderBoardExample example = new LeaderBoardExample();
        LeaderBoardExample.Criteria criteria = example.createCriteria();
        doIf(StringUtils.isNotBlank(tag), () -> criteria.andTagLike("%" + tag + "%"));
        // 审核通过
        criteria.andStatusEqualTo("2");
        List<LeaderBoard> list = leaderBoardService.selectByExample(example);
        return AjaxResult.successData(200, getDataTable(list));
    }

    @ApiOperation(value = "获取排行榜对象", notes = "获取排行榜对象")
    @GetMapping("/object/list")
    public AjaxResult objectList(Integer page, Integer pageSize, Long leaderBoardId) {
        startPage(page, pageSize);
        if (leaderBoardId == null) {
            return AjaxResult.error(500, "leaderBoardId 不能为空！");
        }
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        LeaderBoardObjectExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardIdEqualTo(leaderBoardId);
        // 审核通过
        criteria.andStatusEqualTo("2");
        example.setOrderByClause("star desc");
        List<LeaderBoardObject> list = leaderBoardObjectService.selectByExample(example);
        return AjaxResult.successData(200, getDataTable(list));
    }

    @ApiOperation(value = "评论", notes = "评论")
    @PostMapping("/evaluate")
    public AjaxResult evaluate(@RequestBody LeaderBoardEvaluate evaluate) {
        evaluate.setSendDate(new Date());
        if (evaluate.getId() == null) {
            evaluate.setCreateBy(evaluate.getUserId());
            evaluate.setCreateTime(new Date());
            leaderBoardEvaluateService.insertSelective(evaluate);
        } else {
            evaluate.setUpdateBy(evaluate.getUserId());
            evaluate.setUpdateTime(new Date());
            leaderBoardEvaluateService.updateByPrimaryKeySelective(evaluate);
        }
        return AjaxResult.successData(200, evaluate);
    }

    @ApiOperation(value = "点亮", notes = "点亮")
    @PostMapping("/star")
    public AjaxResult star(@RequestBody LeaderBoardEvaluateStar star) {
        leaderBoardEvaluateStarService.insertSelective(star);
        return AjaxResult.successData(200, star);
    }

    @ApiOperation(value = "点亮", notes = "点亮")
    @PostMapping("/remove/star")
    public AjaxResult removeStar(@RequestBody LeaderBoardEvaluateStar star) {
        if (star.getUserId() == null) {
            return AjaxResult.error(500, "userId 不能为空！");
        }
        LeaderBoardEvaluateStarExample example = new LeaderBoardEvaluateStarExample();
        LeaderBoardEvaluateStarExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(star.getUserId());
        doIf(star.getLeaderBoardObjectId() != null, () -> criteria.andLeaderBoardObjectIdEqualTo(star.getLeaderBoardObjectId()));
        doIf(star.getEvaluateId() != null, () -> criteria.andEvaluateIdEqualTo(star.getEvaluateId()));
        int i = leaderBoardEvaluateStarService.deleteByExample(example);
        return AjaxResult.successData(200, i == 1);
    }
}

package com.nuoquan.api;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.nuoquan.admin.controller.BeanCopyUtils.map;
import static com.nuoquan.admin.controller.BeanCopyUtils.mapBy;
import static com.nuoquan.admin.controller.FunctionUtils.doIf;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.nuoquan.api.service.CommonService;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.pojo.*;
import com.nuoquan.pojo.vo.LeaderBoardEvaluateVO;
import com.nuoquan.pojo.vo.LeaderBoardObjectVO;
import com.nuoquan.pojo.vo.LeaderBoardVO;
import com.nuoquan.pojo.vo.UserVO;
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
    @Autowired
    private CommonService                  commonService;

    @Value("${leaderBoard.approval.auto}")
    private boolean                        approvalFlag;

    @ApiOperation(value = "获取TAG", notes = "获取TAG")
    @GetMapping("/tag/list")
    public AjaxResult tag() {
        List<LeaderBoardTag> tagList = leaderBoardTagService.selectByExample(null);
        return AjaxResult.successData(200, tagList);
    }

    @ApiOperation(value = "获取排行榜", notes = "获取排行榜")
    @GetMapping("/list")
    public AjaxResult view(Integer pageNum, Integer pageSize, String tag, String name) {
        startPage(pageNum, pageSize);
        LeaderBoardExample example = new LeaderBoardExample();
        LeaderBoardExample.Criteria criteria = example.createCriteria();
        doIf(StringUtils.isNotBlank(tag), () -> criteria.andTagLike("%" + tag + "%"));
        doIf(StringUtils.isNotBlank(name), () -> criteria.andNameLike("%" + name + "%"));
        // 审核通过
        criteria.andStatusEqualTo("2");
        List<LeaderBoard> list = leaderBoardService.selectByExample(example);
        long total = new PageInfo<>(list).getTotal();
        List<LeaderBoardVO> leaderBoardVOS = mapBy(list, x -> map(x, LeaderBoardVO.class));
        leaderBoardVOS.forEach(x -> {
            x.setLeaderBoardObjectList(commonService.topThreeObject(x.getId()));
        });
        return AjaxResult.successData(200, getDataTable(leaderBoardVOS, total));
    }

    @ApiOperation(value = "获取排行榜", notes = "获取排行榜")
    @GetMapping("/my/list")
    public AjaxResult myList(Integer pageNum, Integer pageSize, String userId) {
        startPage(pageNum, pageSize);
        LeaderBoardExample example = new LeaderBoardExample();
        LeaderBoardExample.Criteria criteria = example.createCriteria();
        criteria.andCreateByEqualTo(userId);
        // 审核通过
        List<LeaderBoard> list = leaderBoardService.selectByExample(example);
        long total = new PageInfo<>(list).getTotal();
        List<LeaderBoardVO> leaderBoardVOS = mapBy(list, x -> map(x, LeaderBoardVO.class));
        leaderBoardVOS.forEach(x -> {
            x.setLeaderBoardObjectList(commonService.topThreeObject(x.getId()));
        });
        return AjaxResult.successData(200, getDataTable(leaderBoardVOS, total));
    }

    @ApiOperation(value = "创建排行榜", notes = "创建排行榜")
    @PostMapping("/create")
    public AjaxResult view(@RequestBody LeaderBoardVO leaderBoard) {
        if (leaderBoard.getName() == null) {
            return AjaxResult.error(500, "参数不正确");
        }
        LeaderBoardExample example = new LeaderBoardExample();
        LeaderBoardExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(leaderBoard.getName());
        criteria.andStatusEqualTo("2");
        List<LeaderBoard> leaderBoards = leaderBoardService.selectByExample(example);
        if (!leaderBoards.isEmpty()) {
            return AjaxResult.error(500, "排行榜已存在！");
        }
        return AjaxResult.successData(200, commonService.insertLeaderBoard(leaderBoard));
    }

    @ApiOperation(value = "创建排行榜对象", notes = "创建排行榜对象")
    @PostMapping("/create/object")
    public AjaxResult view(@RequestBody LeaderBoardObject leaderBoardObject) {
        if (leaderBoardObject.getName() == null || leaderBoardObject.getLeaderBoardId() == null) {
            return AjaxResult.error(500, "参数不正确");
        }
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        LeaderBoardObjectExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(leaderBoardObject.getName());
        criteria.andLeaderBoardIdEqualTo(leaderBoardObject.getLeaderBoardId());
        criteria.andStatusEqualTo("2");
        List<LeaderBoardObject> leaderBoards = leaderBoardObjectService.selectByExample(example);
        if (!leaderBoards.isEmpty()) {
            return AjaxResult.error(500, "排行榜对象已存在！");
        }
        // 审核状态
        leaderBoardObject.setStatus("1");
        if (approvalFlag) {
            leaderBoardObject.setStatus("2");
        }
        return AjaxResult.successData(200, leaderBoardObjectService.insertSelective(leaderBoardObject));
    }

    @ApiOperation(value = "获取排行榜对象", notes = "获取排行榜对象")
    @GetMapping("/object/list")
    public AjaxResult objectList(Integer pageNum, Integer pageSize, Long leaderBoardId, String sortType) {
        startPage(pageNum, pageSize);
        if (leaderBoardId == null) {
            return AjaxResult.error(500, "leaderBoardId 不能为空！");
        }
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        LeaderBoardObjectExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardIdEqualTo(leaderBoardId);
        // 审核通过
        criteria.andStatusEqualTo("2");
        doIf("nums".equals(sortType), () -> example.setOrderByClause("evaluate_nums desc"));
        doIf("times".equals(sortType), () -> example.setOrderByClause("create_time desc"));
        List<LeaderBoardObject> list = leaderBoardObjectService.selectByExample(example);
        long total = new PageInfo<>(list).getTotal();
        List<LeaderBoardObjectVO> leaderBoardObjects = mapBy(list, x -> map(x, LeaderBoardObjectVO.class));
        // 设置评论
        leaderBoardObjects.forEach(x -> {
            x.setLeaderBoardEvaluateList(commonService.topEvaluate(x.getId()));
        });
        return AjaxResult.successData(200, getDataTable(leaderBoardObjects, total));
    }

    @ApiOperation(value = "获取排行榜对象", notes = "获取排行榜对象")
    @GetMapping("/object/my/list")
    public AjaxResult myObjectList(Integer pageNum, Integer pageSize, String userId) {
        startPage(pageNum, pageSize);
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        LeaderBoardObjectExample.Criteria criteria = example.createCriteria();
        criteria.andCreateByEqualTo(userId);
        List<LeaderBoardObject> list = leaderBoardObjectService.selectByExample(example);
        long total = new PageInfo<>(list).getTotal();
        List<LeaderBoardObjectVO> leaderBoardObjects = mapBy(list, x -> map(x, LeaderBoardObjectVO.class));
        // 设置评论
        leaderBoardObjects.forEach(x -> {
            x.setLeaderBoardEvaluateList(commonService.topEvaluate(x.getId()));
        });
        return AjaxResult.successData(200, getDataTable(leaderBoardObjects, total));
    }

    @ApiOperation(value = "获取排行榜对象", notes = "获取排行榜对象")
    @GetMapping("/object/detail/{id}")
    public AjaxResult detail(Integer pageNum, Integer pageSize, @PathVariable("id") Long id, String userId) {
        LeaderBoardObject leaderBoardObject = leaderBoardObjectService.selectByPrimaryKey(String.valueOf(id));
        if (leaderBoardObject == null) {
            return AjaxResult.error("排行榜对象不存在！");
        }
        // 设置评论
        LeaderBoardObjectVO vo = map(leaderBoardObject, LeaderBoardObjectVO.class);
        vo.setLeaderBoardEvaluateList(commonService.topEvaluate(vo.getId()));
        vo.setStarMap(commonService.starMap(vo.getId()));
        vo.setEvaluateFlag(!commonService.checkEvaluate(id, userId));
        UserVO vo1 = userService.getUserById(vo.getCreateBy());
        doIf(vo1 != null,()->vo.setCreateByNickname(vo1.getNickname()));
        return AjaxResult.successData(200, vo);
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @GetMapping("/evaluate/list")
    public AjaxResult evaluateList(Integer pageNum, Integer pageSize, Long leaderBoardObjectId, String userId) {
        startPage(pageNum, pageSize);
        if (leaderBoardObjectId == null) {
            return AjaxResult.error(500, "leaderBoardObjectId 不能为空！");
        }
        LeaderBoardEvaluateExample example = new LeaderBoardEvaluateExample();
        LeaderBoardEvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardObjectIdEqualTo(leaderBoardObjectId);
        example.setOrderByClause("star_num desc");
        List<LeaderBoardEvaluate> list = leaderBoardEvaluateService.selectByExample(example);
        long total = new PageInfo<>(list).getTotal();
        List<LeaderBoardEvaluateVO> leaderBoardEvaluateVOS = mapBy(list, x -> map(x, LeaderBoardEvaluateVO.class));

        leaderBoardEvaluateVOS.forEach(x -> {
            x.setStarFlag(!commonService.checkStar(x.getId(), userId));
            UserVO vo = userService.getUserById(x.getUserId());
            doIf(vo != null, () -> {
                x.setNickname(vo.getNickname());
                x.setFaceImg(vo.getFaceImg());
            });
        });

        return AjaxResult.successData(200, getDataTable(leaderBoardEvaluateVOS, total));
    }

    @ApiOperation(value = "评论", notes = "评论")
    @PostMapping("/evaluate")
    public AjaxResult evaluate(@RequestBody LeaderBoardEvaluate evaluate) {
        evaluate.setSendDate(new Date());
        if (evaluate.getId() == null) {
            if (!commonService.checkEvaluate(evaluate.getLeaderBoardObjectId(), evaluate.getUserId())) {
                return AjaxResult.error(500, "已经评论过了！");
            }
            evaluate.setCreateBy(evaluate.getUserId());
            evaluate.setCreateTime(new Date());
            leaderBoardEvaluateService.insertSelective(evaluate);
            // 评论数 + 1
            commonService.addEvaluateCount(evaluate.getLeaderBoardObjectId());
        } else {
            evaluate.setUpdateBy(evaluate.getUserId());
            evaluate.setUpdateTime(new Date());
            leaderBoardEvaluateService.updateByPrimaryKeySelective(evaluate);
        }
        commonService.averageStar(evaluate.getLeaderBoardObjectId());
        return AjaxResult.successData(200, evaluate);
    }

    @ApiOperation(value = "点亮", notes = "点亮")
    @PostMapping("/star")
    public AjaxResult star(@RequestBody LeaderBoardEvaluateStar star) {
        if (!commonService.checkStar(star.getEvaluateId(), star.getUserId())) {
            return AjaxResult.error(500, "已经点亮过了！");
        }
        leaderBoardEvaluateStarService.insertSelective(star);
        commonService.addStarNum(star.getEvaluateId());
        return AjaxResult.successData(200, star);
    }

    @ApiOperation(value = "取消点亮", notes = "取消点亮")
    @PostMapping("/remove/star")
    public AjaxResult removeStar(@RequestBody LeaderBoardEvaluateStar star) {
        if (star.getUserId() == null || star.getEvaluateId() == null) {
            return AjaxResult.error(500, "参数为空！");
        }
        if (commonService.checkStar(star.getEvaluateId(), star.getUserId())) {
            return AjaxResult.error(500, "点亮不存在！");
        }
        LeaderBoardEvaluateStarExample example = new LeaderBoardEvaluateStarExample();
        LeaderBoardEvaluateStarExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(star.getUserId());
        doIf(star.getLeaderBoardObjectId() != null, () -> criteria.andLeaderBoardObjectIdEqualTo(star.getLeaderBoardObjectId()));
        doIf(star.getEvaluateId() != null, () -> criteria.andEvaluateIdEqualTo(star.getEvaluateId()));
        int i = leaderBoardEvaluateStarService.deleteByExample(example);
        commonService.removeStarNum(star.getEvaluateId());
        return AjaxResult.successData(200, i == 1);
    }
}

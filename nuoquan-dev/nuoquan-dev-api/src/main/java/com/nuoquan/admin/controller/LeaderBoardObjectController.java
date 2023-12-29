package com.nuoquan.admin.controller;

import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.LeaderBoard;
import com.nuoquan.pojo.LeaderBoardExample;
import com.nuoquan.pojo.LeaderBoardObject;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.service.LeaderBoardObjectService;
import com.nuoquan.service.LeaderBoardService;
import com.nuoquan.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.nuoquan.admin.controller.FunctionUtils.doIf;
import static com.nuoquan.util.CommonUtil.approvalStatus;

/**
 * 排行榜主表Controller
 *
 * @author xxdd
 * @ClassName: LeaderBoardObjectController
 * @date 2023-12-23 15:05:38
 */
@Api(value = "排行榜主表")
@Controller
@RequestMapping("/LeaderBoardObjectController")
public class LeaderBoardObjectController extends BasicController {

    private String prefix = "admin/leaderBoardObject";

    @Autowired
    private LeaderBoardObjectService leaderBoardObjectService;

    @Autowired
    private LeaderBoardService leaderBoardService;


    /**
     * 排行榜主表页面展示
     *
     * @author xxdd
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:leaderBoardObject:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }

    /**
     * list集合
     *
     * @return
     */
    //@Log(title = "排行榜主表", action = "111")
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/list")
    @RequiresPermissions("gen:leaderBoardObject:list")
    @ResponseBody
    public ResultTable list(TableparV2 tablepar, LeaderBoardObject leaderBoardObject) {
        PageInfo<LeaderBoardObject> page = leaderBoardObjectService.list(tablepar, leaderBoardObject);
        List<LeaderBoardObject> list = page.getList();
        list.stream().forEach(x -> {
            doIf(StringUtils.isNotBlank(x.getStatus()), () -> x.setStatus(approvalStatus.get(x.getStatus())));
            doIf(StringUtils.isNotEmpty(x.getLeaderBoardId()), () -> {
                LeaderBoard leaderBoard = leaderBoardService.selectByPrimaryKey(x.getLeaderBoardId());
                x.setLeaderBoardId(leaderBoard == null ? null : leaderBoard.getName());
            });
        });
        return pageTable(page.getList(), page.getTotal());
    }

    /**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        LeaderBoardExample example = new LeaderBoardExample();
        example.createCriteria().andStatusEqualTo("2");
        List<LeaderBoard> leaderBoards = leaderBoardService.selectByExample(example);
        modelMap.put("leaderBoards", leaderBoards);
        modelMap.put("approvalStatus", approvalStatus);
        return prefix + "/add";
    }

    /**
     * 新增保存
     *
     * @param
     * @return
     */
    //@Log(title = "排行榜主表新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:leaderBoardObject:add")
    @ResponseBody
    public AjaxResult add(LeaderBoardObject leaderBoardObject) {
        leaderBoardObject.setCreateTime(new Date());
        leaderBoardObject.setCreateBy(getLoginUser().getUsername());
        int b = leaderBoardObjectService.insertSelective(leaderBoardObject);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 排行榜主表删除
     *
     * @param ids
     * @return
     */
    //@Log(title = "排行榜主表删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:leaderBoardObject:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = leaderBoardObjectService.deleteByPrimaryKey(ids);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * 修改跳转
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "修改跳转", notes = "修改跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map) {
        map.put("LeaderBoardObject", leaderBoardObjectService.selectByPrimaryKey(id));
        LeaderBoardExample example = new LeaderBoardExample();
        example.createCriteria().andStatusEqualTo("2");
        List<LeaderBoard> leaderBoards = leaderBoardService.selectByExample(example);
        map.put("leaderBoards", leaderBoards);
        map.put("approvalStatus", approvalStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "排行榜主表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:leaderBoardObject:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LeaderBoardObject leaderBoardObject) {
        leaderBoardObject.setUpdateTime(new Date());
        leaderBoardObject.setUpdateBy(getLoginUser().getUsername());
        return toAjax(leaderBoardObjectService.updateByPrimaryKeySelective(leaderBoardObject));
    }


    /**
     * 修改状态
     *
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody LeaderBoardObject leaderBoardObject) {
        int i = leaderBoardObjectService.updateVisible(leaderBoardObject);
        return toAjax(i);
    }


}

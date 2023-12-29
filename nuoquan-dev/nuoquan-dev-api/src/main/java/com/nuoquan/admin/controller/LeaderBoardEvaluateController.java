package com.nuoquan.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.LeaderBoardEvaluate;
import com.nuoquan.pojo.LeaderBoardObject;
import com.nuoquan.pojo.LeaderBoardObjectExample;
import com.nuoquan.pojo.User;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.service.LeaderBoardEvaluateService;
import com.nuoquan.service.LeaderBoardObjectService;
import com.nuoquan.service.UserService;
import com.nuoquan.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static com.nuoquan.admin.controller.FunctionUtils.doIf;
import static com.nuoquan.domain.AjaxResult.successData;

/**
 * 排行榜评论表Controller
 *
 * @author xxdd
 * @ClassName: LeaderBoardEvaluateController
 * @date 2023-12-23 15:05:35
 */
@Api(value = "排行榜评论表")
@Controller
@RequestMapping("/LeaderBoardEvaluateController")
public class LeaderBoardEvaluateController extends BasicController {

    private String prefix = "admin/leaderBoardEvaluate";

    @Autowired
    private LeaderBoardEvaluateService leaderBoardEvaluateService;

    @Autowired
    private UserService userService;


    @Autowired
    private LeaderBoardObjectService leaderBoardObjectService;


    /**
     * 排行榜评论表页面展示
     *
     * @author xxdd
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:leaderBoardEvaluate:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }

    /**
     * list集合
     *
     * @return
     */
    //@Log(title = "排行榜评论表", action = "111")
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/list")
    @RequiresPermissions("gen:leaderBoardEvaluate:list")
    @ResponseBody
    public ResultTable list(TableparV2 tablepar, LeaderBoardEvaluate leaderBoardEvaluate) {
        PageInfo<LeaderBoardEvaluate> page = leaderBoardEvaluateService.list(tablepar, leaderBoardEvaluate);
        return pageTable(page.getList(), page.getTotal());
    }

    /**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        example.createCriteria().andStatusEqualTo("2");
        List<LeaderBoardObject> leaderBoardObjects = leaderBoardObjectService.selectByExample(example);
        modelMap.put("leaderBoardObjects", leaderBoardObjects);

        return prefix + "/add";
    }

    /**
     * 新增保存
     *
     * @param
     * @return
     */
    //@Log(title = "排行榜评论表新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:leaderBoardEvaluate:add")
    @ResponseBody
    public AjaxResult add(LeaderBoardEvaluate leaderBoardEvaluate) {
        int b = leaderBoardEvaluateService.insertSelective(leaderBoardEvaluate);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }


    @ApiOperation(value = "新增", notes = "新增")
    @GetMapping("/getUser")
    @RequiresPermissions("gen:leaderBoardEvaluate:add")
    @ResponseBody
    public AjaxResult getUser(String name) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("state", "1");
        doIf(StringUtils.isNotBlank(name), () -> criteria.andLike("nickname", "%" + name + "%"));
//        doIf(StringUtils.isBlank(name),()->  PageHelper.startPage(0, 50));
        List<User> result = userMapper.selectByExample(userExample);
        return successData(200, result);
    }

    /**
     * 排行榜评论表删除
     *
     * @param ids
     * @return
     */
    //@Log(title = "排行榜评论表删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:leaderBoardEvaluate:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = leaderBoardEvaluateService.deleteByPrimaryKey(ids);
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
        map.put("LeaderBoardEvaluate", leaderBoardEvaluateService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "排行榜评论表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:leaderBoardEvaluate:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LeaderBoardEvaluate leaderBoardEvaluate) {
        return toAjax(leaderBoardEvaluateService.updateByPrimaryKeySelective(leaderBoardEvaluate));
    }


    /**
     * 修改状态
     *
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody LeaderBoardEvaluate leaderBoardEvaluate) {
        int i = leaderBoardEvaluateService.updateVisible(leaderBoardEvaluate);
        return toAjax(i);
    }


}

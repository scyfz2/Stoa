package com.nuoquan.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.LotteryHistory;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.service.LotteryHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 中奖记录表Controller
 * 
 * @ClassName: LotteryHistoryController
 * @author fuce
 * @date 2023-08-20 01:31:23
 */
@Api(value = "中奖记录表")
@Controller
@RequestMapping("/LotteryHistoryController")
public class LotteryHistoryController extends BasicController {

    private String                prefix = "admin/lotteryHistory";

    @Autowired
    private LotteryHistoryService lotteryHistoryService;

    /**
     * 中奖记录表页面展示
     * 
     * @param model
     * @return String
     * @author fuce
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:lotteryHistory:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }

    /**
     *
     * @param tablepar
     * @param lotteryHistory
     * @return
     */
    //@Log(title = "中奖记录表", action = "111")
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/list")
    @RequiresPermissions("gen:lotteryHistory:list")
    @ResponseBody
    public ResultTable list(TableparV2 tablepar, LotteryHistory lotteryHistory) {
        PageInfo<LotteryHistory> page = lotteryHistoryService.list(tablepar, lotteryHistory);
        return pageTable(page.getList(), page.getTotal());
    }

    /**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        return prefix + "/add";
    }

    /**
     * 新增保存
     * 
     * @param
     * @return
     */
    //@Log(title = "中奖记录表新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:lotteryHistory:add")
    @ResponseBody
    public AjaxResult add(LotteryHistory lotteryHistory) {
        int b = lotteryHistoryService.insertSelective(lotteryHistory);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 中奖记录表删除
     * 
     * @param ids
     * @return
     */
    //@Log(title = "中奖记录表删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:lotteryHistory:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = lotteryHistoryService.deleteByPrimaryKey(ids);
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
     * @param mmap
     * @return
     */
    @ApiOperation(value = "修改跳转", notes = "修改跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map) {
        map.put("LotteryHistory", lotteryHistoryService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "中奖记录表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:lotteryHistory:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LotteryHistory lotteryHistory) {
        return toAjax(lotteryHistoryService.updateByPrimaryKeySelective(lotteryHistory));
    }

    /**
     * 修改状态
     * 
     * @param record
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody LotteryHistory lotteryHistory) {
        int i = lotteryHistoryService.updateVisible(lotteryHistory);
        return toAjax(i);
    }

}

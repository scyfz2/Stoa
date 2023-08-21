package com.nuoquan.admin.controller;

import com.nuoquan.pojo.vo.TitleVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.MeriHistory;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.service.MeriHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 功德领取记录表Controller
 * 
 * @ClassName: MeriHistoryController
 * @author fuce
 * @date 2023-08-21 20:46:05
 */
@Api(value = "功德领取记录表")
@Controller
@RequestMapping("/MeriHistoryController")
public class MeriHistoryController extends BasicController {

    private String             prefix = "admin/meriHistory";

    @Autowired
    private MeriHistoryService meriHistoryService;

    /**
     * 功德领取记录表页面展示
     * 
     * @param model
     * @return String
     * @author fuce
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:meriHistory:view")
    public String view(ModelMap model) {
        setTitle(model, new TitleVO("列表", "管理", true, "欢迎进入页面", true, false));
        return prefix + "/list";
    }

    /**
     * list集合
     * 
     * @param tablepar
     * @param meriHistory
     * @return
     */
    //@Log(title = "功德领取记录表", action = "111")
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/list")
    @RequiresPermissions("gen:meriHistory:list")
    @ResponseBody
    public ResultTable list(TableparV2 tablepar, MeriHistory meriHistory) {
        PageInfo<MeriHistory> page = meriHistoryService.list(tablepar, meriHistory);
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
    //@Log(title = "功德领取记录表新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:meriHistory:add")
    @ResponseBody
    public AjaxResult add(MeriHistory meriHistory) {
        int b = meriHistoryService.insertSelective(meriHistory);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 功德领取记录表删除
     * 
     * @param ids
     * @return
     */
    //@Log(title = "功德领取记录表删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:meriHistory:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = meriHistoryService.deleteByPrimaryKey(ids);
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
        map.put("MeriHistory", meriHistoryService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "功德领取记录表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:meriHistory:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MeriHistory meriHistory) {
        return toAjax(meriHistoryService.updateByPrimaryKeySelective(meriHistory));
    }

    /**
     * 修改状态
     * 
     * @param record
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody MeriHistory meriHistory) {
        int i = meriHistoryService.updateVisible(meriHistory);
        return toAjax(i);
    }

}

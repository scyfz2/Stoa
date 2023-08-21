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
import com.nuoquan.pojo.LotteryConfig;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.vo.TitleVO;
import com.nuoquan.service.LotteryConfigService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 奖品配置表Controller
 * 
 * @ClassName: LotteryConfigController
 * @author fuce
 * @date 2023-08-19 22:47:40
 */
@Api(value = "奖品配置表")
@Controller
@RequestMapping("/LotteryConfigController")
public class LotteryConfigController extends BasicController {

    private String               prefix = "admin/lotteryConfig";

    @Autowired
    private LotteryConfigService lotteryConfigService;

    /**
     * 奖品配置表页面展示
     * 
     * @param model
     * @return String
     * @author fuce
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:lotteryConfig:view")
    public String view(ModelMap model) {
        setTitle(model, new TitleVO("列表", "管理", true, "欢迎进入页面", true, false));
        return prefix + "/list";
    }

    /**
     * list集合
     * 
     * @param tableparV2
     * @param lotteryConfig
     * @return
     */
    //@Log(title = "奖品配置表", action = "111")
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/list")
    @RequiresPermissions("gen:lotteryConfig:list")
    @ResponseBody
    public ResultTable list(TableparV2 tableparV2, LotteryConfig lotteryConfig) {
        PageInfo<LotteryConfig> page = lotteryConfigService.list(tableparV2, lotteryConfig);
        return pageTable(page.getList(), page.getTotal());
    }

    /**--
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
    //@Log(title = "奖品配置表新增", action = "111")
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    @RequiresPermissions("gen:lotteryConfig:add")
    @ResponseBody
    public AjaxResult add(LotteryConfig lotteryConfig) {
        int b = lotteryConfigService.insertSelective(lotteryConfig);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 奖品配置表删除
     * 
     * @param ids
     * @return
     */
    //@Log(title = "奖品配置表删除", action = "111")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    @RequiresPermissions("gen:lotteryConfig:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = lotteryConfigService.deleteByPrimaryKey(ids);
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
     * @param map
     * @return
     */
    @ApiOperation(value = "修改跳转", notes = "修改跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map) {
        map.put("LotteryConfig", lotteryConfigService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "奖品配置表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:lotteryConfig:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LotteryConfig lotteryConfig) {
        return toAjax(lotteryConfigService.updateByPrimaryKeySelective(lotteryConfig));
    }

    /**
     * 修改状态
     * 
     * @param lotteryConfig
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody LotteryConfig lotteryConfig) {
        int i = lotteryConfigService.updateVisible(lotteryConfig);
        return toAjax(i);
    }

}

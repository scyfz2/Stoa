package com.nuoquan.admin.controller;

import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.LeaderBoardEvaluateStar;
import com.nuoquan.service.LeaderBoardEvaluateStarService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * 排行榜评论点亮表Controller
 * @ClassName: LeaderBoardEvaluateStarController
 * @author xxdd
 * @date 2023-12-23 15:05:37
 */
@Api(value = "排行榜评论点亮表")
@Controller
@RequestMapping("/LeaderBoardEvaluateStarController")
public class LeaderBoardEvaluateStarController extends BasicController{
	
	private String prefix = "admin/leaderBoardEvaluateStar";
	
	@Autowired
	private LeaderBoardEvaluateStarService leaderBoardEvaluateStarService;
	
	
	/**
	 * 排行榜评论点亮表页面展示
	 * @author xxdd
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:leaderBoardEvaluateStar:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @return
	 */
	//@Log(title = "排行榜评论点亮表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:leaderBoardEvaluateStar:list")
	@ResponseBody
	public ResultTable list(TableparV2 tablepar,LeaderBoardEvaluateStar leaderBoardEvaluateStar){
		PageInfo<LeaderBoardEvaluateStar> page=leaderBoardEvaluateStarService.list(tablepar,leaderBoardEvaluateStar) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "排行榜评论点亮表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:leaderBoardEvaluateStar:add")
	@ResponseBody
	public AjaxResult add(LeaderBoardEvaluateStar leaderBoardEvaluateStar){
		int b=leaderBoardEvaluateStarService.insertSelective(leaderBoardEvaluateStar);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 排行榜评论点亮表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "排行榜评论点亮表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:leaderBoardEvaluateStar:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=leaderBoardEvaluateStarService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("LeaderBoardEvaluateStar", leaderBoardEvaluateStarService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "排行榜评论点亮表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:leaderBoardEvaluateStar:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LeaderBoardEvaluateStar leaderBoardEvaluateStar)
    {
        return toAjax(leaderBoardEvaluateStarService.updateByPrimaryKeySelective(leaderBoardEvaluateStar));
    }
    
    
    /**
	 * 修改状态
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody LeaderBoardEvaluateStar leaderBoardEvaluateStar){
		int i=leaderBoardEvaluateStarService.updateVisible(leaderBoardEvaluateStar);
		return toAjax(i);
	}

    
    

	
}

package com.nuoquan.admin.controller;


import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.RankingList;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.vo.RankListVO;
import com.nuoquan.service.RankingListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 排行榜Controller
 * @ClassName: RankingListController
 * @author fuce
 * @date 2023-08-21 21:34:32
 */
@Api(value = "排行榜")
@Controller
@RequestMapping("/RankingListController")
public class RankingListController extends BasicController {
	
	private String prefix = "admin/rankingList";
	
	@Autowired
	private RankingListService rankingListService;
	
	
	/**
	 * 排行榜页面展示
	 * @param model
	 * @return String
	 * @author fuce
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:rankingList:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param rankingList
	 * @return
	 */
	//@Log(title = "排行榜", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:rankingList:list")
	@ResponseBody
	public ResultTable list(TableparV2 tablepar, RankingList rankingList){
		PageInfo<RankListVO> page=rankingListService.list(tablepar,rankingList) ;
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
	//@Log(title = "排行榜新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:rankingList:add")
	@ResponseBody
	public AjaxResult add(RankingList rankingList){
		int b=rankingListService.insertSelective(rankingList);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 排行榜删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "排行榜删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:rankingList:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=rankingListService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("RankingList", rankingListService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "排行榜修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:rankingList:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RankingList rankingList)
    {
        return toAjax(rankingListService.updateByPrimaryKeySelective(rankingList));
    }
    
    
    /**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody RankingList rankingList){
		int i=rankingListService.updateVisible(rankingList);
		return toAjax(i);
	}

    
    

	
}

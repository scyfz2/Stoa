package com.nuoquan.admin.controller;

import static com.nuoquan.admin.controller.FunctionUtils.doIf;
import static com.nuoquan.util.CommonUtil.approvalStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.nuoquan.controller.BasicController;
import com.nuoquan.domain.AjaxResult;
import com.nuoquan.domain.ResultTable;
import com.nuoquan.pojo.LeaderBoard;
import com.nuoquan.pojo.LeaderBoardTag;
import com.nuoquan.pojo.LeaderBoardTagExample;
import com.nuoquan.pojo.admin.TableparV2;
import com.nuoquan.pojo.vo.LeaderBoardTagVO;
import com.nuoquan.service.LeaderBoardService;
import com.nuoquan.service.LeaderBoardTagService;
import com.nuoquan.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 排行榜主表Controller
 * 
 * @ClassName: LeaderBoardController
 * @author xxdd
 * @date 2023-12-23 15:01:06
 */
@Api(value = "排行榜主表")
@Controller
@RequestMapping("/LeaderBoardController")
public class LeaderBoardController extends BasicController {

    private String                prefix = "admin/leaderBoard";

    @Autowired
    private LeaderBoardService    leaderBoardService;
    @Autowired
    private LeaderBoardTagService tagService;

    /**
     * 排行榜主表页面展示
     * 
     * @author xxdd
     */
    @ApiOperation(value = "分页跳转", notes = "分页跳转")
    @GetMapping("/view")
    @RequiresPermissions("gen:leaderBoard:view")
    public String view(ModelMap model) {
        List<LeaderBoardTag> leaderBoardTags = tagService.selectByExample(new LeaderBoardTagExample());
        model.put("tagsList", leaderBoardTags);
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
    @RequiresPermissions("gen:leaderBoard:list")
    @ResponseBody
    public ResultTable list(TableparV2 tablepar, LeaderBoard leaderBoard) {
        PageInfo<LeaderBoard> page = leaderBoardService.list(tablepar, leaderBoard);
        List<LeaderBoardTag> leaderBoardTags = tagService.selectByExample(new LeaderBoardTagExample());
        List<LeaderBoard> list = page.getList();
        doIf(!leaderBoardTags.isEmpty(), () -> {
            // 根据 id 和 tagName 转成 Map
            Map<Long, String> map = leaderBoardTags.stream().collect(Collectors.toMap(LeaderBoardTag::getId, LeaderBoardTag::getTagName));
            list.stream().forEach(x -> {
                if (x.getTag() != null) {
                    String[] tagArr = x.getTag().split(",");
                    String tagStr = "";
                    for (String s : tagArr) {
                        tagStr += map.get(Long.parseLong(s)) + ",";
                    }
                    x.setTag(tagStr.substring(0, tagStr.length() - 1));
                }
            });
        });
        list.stream().forEach(x -> {
            doIf(StringUtils.isNotBlank(x.getStatus()), () -> x.setStatus(approvalStatus.get(x.getStatus())));
        });
        return pageTable(list, page.getTotal());
    }

    /**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<LeaderBoardTag> leaderBoardTags = tagService.selectByExample(new LeaderBoardTagExample());
        modelMap.put("tagsList", leaderBoardTags);
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
    @RequiresPermissions("gen:leaderBoard:add")
    @ResponseBody
    public AjaxResult add(LeaderBoard leaderBoard) {
        leaderBoard.setCreateTime(new Date());
        leaderBoard.setCreateBy(getLoginUser().getUsername());
        int b = leaderBoardService.insertSelective(leaderBoard);
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
    @RequiresPermissions("gen:leaderBoard:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = leaderBoardService.deleteByPrimaryKey(ids);
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
        LeaderBoard leaderBoard = leaderBoardService.selectByPrimaryKey(id);
        map.put("LeaderBoard", leaderBoard);
        List<LeaderBoardTag> leaderBoardTags = tagService.selectByExample(new LeaderBoardTagExample());
        List<LeaderBoardTagVO> leaderBoardTagVOS = BeanCopyUtils.mapBy(leaderBoardTags, x -> BeanCopyUtils.map(x, LeaderBoardTagVO.class));
        if (leaderBoard.getTag() != null) {
            String[] split = leaderBoard.getTag().split(",");
            for (LeaderBoardTagVO tag : leaderBoardTagVOS) {
                for (String s : split) {
                    if (tag.getId().equals(Long.parseLong(s))) {
                        tag.setCheckFlag(true);
                    }
                }
            }
        }
        map.put("tagsList", leaderBoardTagVOS);
        map.put("approvalStatus", approvalStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@Log(title = "排行榜主表修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:leaderBoard:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LeaderBoard leaderBoard) {
        leaderBoard.setUpdateTime(new Date());
        leaderBoard.setUpdateBy(getLoginUser().getUsername());
        return toAjax(leaderBoardService.updateByPrimaryKeySelective(leaderBoard));
    }

    /**
     * 修改状态
     * 
     * @return
     */
    @PutMapping("/updateVisible")
    @ResponseBody
    public AjaxResult updateVisible(@RequestBody LeaderBoard leaderBoard) {
        int i = leaderBoardService.updateVisible(leaderBoard);
        return toAjax(i);
    }

}

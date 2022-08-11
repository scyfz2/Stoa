package com.nuoquan.controller;

import com.nuoquan.enums.StatusEnum;
import com.nuoquan.pojo.EventsCalendar;
import com.nuoquan.utils.JSONResult;
import com.nuoquan.utils.PagedResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 迎新周日程相关接口
 *
 * @author BoyuanYE
 * @Date: 2022.07.05
**/

@RestController
@Api(value = "迎新周日程相关接口", tags = { "EventsCalendar-Controller" })
@RequestMapping("/eventsCalendar")
public class EventsCalendarController extends BasicController {
    /**
     *
     * @param page
     * @param pageSize
     * @param userId 操作者id
     * @param targetDate 查询目标日期
     * @param faculty 学院
     * @param degree 学历
     * @return JSONResult
     * @throws Exception
     */
    @ApiOperation(value = "查询全部日程", notes = "查询全部可读日程的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "操作者id", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "targetDate", value = "查询目标日期", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "faculty", value = "学院", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "degree", value = "学历", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping("/queryEventsCalender")
    public JSONResult queryEventsCalendar(String userId, Integer page, Integer pageSize, Integer targetDate, Integer faculty, Integer degree) throws Exception {

        if(page == null) {
            page = 1;
        }

        if(pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedResult result = eventsCalendarService.queryEventsCalendar(userId, page, pageSize, targetDate, faculty, degree);

        return JSONResult.ok(result);
    }



    @ApiOperation(value = "上传日程", notes = "上传日程的接口")
    @ApiImplicitParams({
            // uniapp使用formData时，paramType要改成form
            @ApiImplicitParam(name="userId", value="操作者id", required=true, dataType="String", paramType="form"),
            @ApiImplicitParam(name="title", value="事件名称", required=true, dataType="String", paramType="form"),
            @ApiImplicitParam(name="venue", value="事件地点", required=true, dataType="String", paramType="form"),
            @ApiImplicitParam(name="date", value="事件日期", required=true, dataType="Integer", paramType="form"),
            @ApiImplicitParam(name="time", value="事件时间", required=true, dataType="String", paramType="form"),
            @ApiImplicitParam(name = "faculty", value = "学院", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "degree", value = "学历", required = true, dataType = "Integer", paramType = "form")
    })
    @PostMapping(value="/uploadEvent")
    public JSONResult uploadEvent(String userId, String title, String venue, Integer date, String time, Integer faculty, Integer degree) throws Exception {

        //TODO: 是否增加ALL选项，简化录入
        if (StringUtils.isBlank(userId) || StringUtils.isEmpty(userId)) {
            return JSONResult.errorMsg("Id can't be null");
        }
        boolean isLegal = false;
        // 保存事件信息到数据库
        //TODO: 这里不要set，使用compose来进行set（degree, faculty, date, vo改为字符串）
        EventsCalendar eventsCalendar = new EventsCalendar();
        eventsCalendar.setEventTitle(title);
        eventsCalendar.setEventVenue(venue);
        eventsCalendar.setEventTime(time);
        eventsCalendar.setCreateDate(new Date());
        // 检测内容是否非法
        if (weChatService.msgSecCheck(title)
                && weChatService.msgSecCheck(venue)
                && weChatService.msgSecCheck(time)) {
            // 合法
            isLegal = true;
            if (resourceConfig.getAutoCheckArticle()) { //查看是否设置自动过审
                eventsCalendar.setStatus(StatusEnum.READABLE.type);
            }else {
                eventsCalendar.setStatus(StatusEnum.CHECKING.type);
            }
        } else {
            // 非法，尽管非法也保存到数据库
            eventsCalendar.setStatus(StatusEnum.DELETED.type);
        }
        String eventId = eventsCalendarService.saveEvent(eventsCalendar);; // 存入数据库

        if (isLegal) {
            return JSONResult.ok(eventId);
        }else {
            return JSONResult.errorMsg("内容违规");
        }
    }
}

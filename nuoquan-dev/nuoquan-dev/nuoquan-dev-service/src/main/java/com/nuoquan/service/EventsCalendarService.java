package com.nuoquan.service;

import com.nuoquan.pojo.EventsCalendar;
import com.nuoquan.utils.PagedResult;

public interface EventsCalendarService {

    /**
     * queryAllEventsCalender接口的方法
     * @param page 前端页数
     * @param pageSize 前端页面大小
     * @param userId 操作者id
     * @param currentDate 查询的目标日期(此参数为null时默认查询所有)
     * @param faculty 学院
     * @param degree 学历
     * @return JSONResult
     */
    public PagedResult queryEventsCalender(Integer page, Integer pageSize, String userId, String currentDate, String faculty, String degree);


    /**
     * queryAllEventsCalender接口的方法
     * @param eventsCalendar EventsCalendar
     * @return JSONResult
     */
    public String saveEvent(EventsCalendar eventsCalendar);
}

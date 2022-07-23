package com.nuoquan.mapper.nq1;

import com.nuoquan.pojo.EventsCalendar;
import com.nuoquan.pojo.vo.EventsCalendarVO;
import com.nuoquan.utils.MyMapper;

import java.util.List;

public interface EventsCalendarMapper extends MyMapper<EventsCalendar> {

    /**
     * @Description: 查询并展示所有为readable状态(status==1)的迎新周事件信息
     * @return 组合好的vo list
     */
    public List<EventsCalendarVO> queryEventsCalendar(String faculty, String degree, String targetDate);
}

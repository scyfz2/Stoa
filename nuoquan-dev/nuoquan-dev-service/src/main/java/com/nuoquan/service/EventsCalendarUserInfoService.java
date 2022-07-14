package com.nuoquan.service;

import com.nuoquan.pojo.vo.EventsCalendarUserInfoVO;
import com.nuoquan.utils.PagedResult;

public interface EventsCalendarUserInfoService {
    /**
     * 查询某用户日程信息
     * @param userId 操作者id
     * @return JSONResult
     */
    public PagedResult queryEventsCalenderUserInfo(Integer page, Integer pageSize, String userId);
}

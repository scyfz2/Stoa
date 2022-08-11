package com.nuoquan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.mapper.nq1.EventsCalendarMapper;
import com.nuoquan.pojo.EventsCalendar;
import com.nuoquan.pojo.vo.EventsCalendarVO;
import com.nuoquan.utils.PagedResult;
import com.nuoquan.utils.RedisOperator;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 迎新周日程业务模型
 * @author BoyuanYE
 * @Date: 2022.07.05
 */
@Service
public class EventsCalendarServiceImpl implements EventsCalendarService{

    @Autowired
    private Sid sid;
    @Autowired
    public RedisOperator redis;
    @Autowired
    private EventsCalendarMapper eventsCalendarMapper;
    /**
     * 把 EventsCalendar 转换为 EventsCalendarVO, 组装日程VO对象
     * @param eventsCalendar
     * @param userId 操作者（我）
     * @return eventsCalendarVO
     */
    public EventsCalendarVO composeEventsCalendarVO(EventsCalendar eventsCalendar, String userId) {
        EventsCalendarVO eventsCalendarVO = new EventsCalendarVO();
        BeanUtils.copyProperties(eventsCalendar, eventsCalendarVO);
        return eventsCalendarVO;
    }

    @Override
    public PagedResult queryEventsCalendar(String userId, Integer page, Integer pageSize, Integer targetDate, Integer faculty, Integer degree){

        // 从controller中获取page和pageSize (经实验，PageHelper 只拦截下一次查询)
        PageHelper.startPage(page, pageSize);
        //TODO: 这里使用compose，将vo的输出全都换成string
        List<EventsCalendarVO> list = eventsCalendarMapper.queryEventsCalendar(faculty, degree, targetDate);

        PageInfo<EventsCalendarVO> pageList = new PageInfo<>(list);

        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(list);
        pagedResult.setRecords(pageList.getTotal());

        return pagedResult;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String saveEvent(EventsCalendar eventsCalendar) {
        String id = sid.nextShort();
        eventsCalendar.setId(id);
        eventsCalendarMapper.insertSelective(eventsCalendar);
        return id;
    }
}

package com.nuoquan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuoquan.enums.StatusEnum;
import com.nuoquan.mapper.nq1.EventsCalendarMapper;
import com.nuoquan.pojo.EventsCalendar;
import com.nuoquan.pojo.vo.EventsCalendarVO;
import com.nuoquan.utils.PageUtils;
import com.nuoquan.utils.PagedResult;
import com.nuoquan.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
    public PagedResult queryEventsCalender(Integer page, Integer pageSize, String userId, String currentDate) {
        Example eventsCalendarExample = new Example(EventsCalendar.class);
        //是否有查询日期
        if(!StringUtils.isBlank(currentDate)) {
            Example.Criteria dateCriteria = eventsCalendarExample.createCriteria();
            // 此处userId为操作者id
            dateCriteria.andEqualTo("eventDate", currentDate);
            eventsCalendarExample.and(dateCriteria);
        }
        // 在这些日程中找到状态为可读的事件
        Example.Criteria statusCriteria = eventsCalendarExample.createCriteria();
        statusCriteria.andEqualTo("status", StatusEnum.READABLE.type);
        eventsCalendarExample.and(statusCriteria);
        eventsCalendarExample.setOrderByClause("create_date desc");

        PageHelper.startPage(page, pageSize);
        return queryEventsCalendarByExample(eventsCalendarExample, userId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedResult queryEventsCalendarByExample(Example eventsCalendarExample, String userId) {
        //通过条件，返回pagedResult
        List<EventsCalendar> list = eventsCalendarMapper.selectByExample(eventsCalendarExample);
        PageInfo<EventsCalendar> pageInfo = new PageInfo<>(list);
        PageInfo<EventsCalendarVO> pageInfoVO = PageUtils.PageInfo2PageInfoVo(pageInfo);

        List<EventsCalendarVO> listVO = new ArrayList<>();
        for (EventsCalendar ec : list) {
            listVO.add(composeEventsCalendarVO(ec, userId));
        }
        pageInfoVO.setList(listVO);

        //为最终返回对象 pagedResult 添加属性
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(pageInfoVO.getPageNum());
        pagedResult.setTotal(pageInfoVO.getPages());
        pagedResult.setRows(pageInfoVO.getList());
        pagedResult.setRecords(pageInfoVO.getTotal());

        return pagedResult;
    }


    /**
     * @param eventId    事件id
     * @param statusType 更改目标状态(0:删除， 1:已过期)
     */
    @Override
    public void changeEventStatus(String eventId, Integer statusType) {
        Example example = new Example(EventsCalendar.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", eventId);
        EventsCalendar ec = new EventsCalendar();
        if (statusType == 0){
            ec.setStatus(StatusEnum.DELETED.type);
        } else {
            ec.setIsOutdated(1);    // 此状态表示该事件为当前日期以前的事件
        }
        eventsCalendarMapper.updateByExampleSelective(ec, example);
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

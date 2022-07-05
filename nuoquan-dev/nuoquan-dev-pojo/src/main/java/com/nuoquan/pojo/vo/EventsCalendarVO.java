package com.nuoquan.pojo.vo;

import java.util.Date;

/**
 * 迎新周日程VO
 * @author BoyuanYE
 * @date: 2022年7月5日 16:50
 */
public class EventsCalendarVO {
    private String id;
    private String eventTitle;
    private String eventDescription;
    private String eventVenue;
    private String eventDate;
    private String eventTime;
    private Integer status;
    private Integer isOutdated;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOutdated() {
        return isOutdated;
    }

    public void setIsOutdated(Integer isOutdated) {
        this.isOutdated = isOutdated;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

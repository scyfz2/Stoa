package com.nuoquan.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class EventsCalendar {
    @Id
    private String id;

    @Column(name = "title")
    private String eventTitle;

    @Column(name = "description")
    private String eventDescription;

    @Column(name = "venue")
    private String eventVenue;

    @Column(name = "date")
    private String eventDate;

    @Column(name = "time")
    private String eventTime;

    @Column(name = "status")
    private Integer status;

    @Column(name = "is_outdated")
    private Integer isOutdated;

    @Column(name = "create_date")
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

    public void setStatus(Integer status) {this.status = status;}

    public Integer getIsOutdated() {return isOutdated;}

    public void setIsOutdated(Integer isOutdated) {this.isOutdated = isOutdated;}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

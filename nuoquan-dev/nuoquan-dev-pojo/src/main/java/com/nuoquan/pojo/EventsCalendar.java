package com.nuoquan.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class EventsCalendar {
    @Id
    private String id;

    @Column(name = "title")
    private String eventTitle;

    @Column(name = "faculty")
    private Integer faculty;

    @Column(name = "degree")
    private Integer degree;

    @Column(name = "venue")
    private String eventVenue;

    @Column(name = "date")
    private Integer eventDate;

    @Column(name = "time")
    private String eventTime;

    @Column(name = "status")
    private Integer status;

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

    public Integer getFaulty() {
        return faculty;
    }

    public void setFaulty(Integer faulty) {
        this.faculty = faulty;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Integer getEventDate() {
        return eventDate;
    }

    public void setEventDate(Integer eventDate) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

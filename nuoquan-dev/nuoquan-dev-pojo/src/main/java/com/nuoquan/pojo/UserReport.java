package com.nuoquan.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_report")
public class UserReport {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "report_user_id")
    private String reportUserId;

    @Column(name = "report_article_id")
    private String reportArticleId;

    private String title;

    @Column(name = "report_content")
    private String reportContent;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return report_user_id
     */
    public String getReportUserId() {
        return reportUserId;
    }

    /**
     * @param reportUserId
     */
    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId;
    }

    /**
     * @return report_article_id
     */
    public String getReportArticleId() {
        return reportArticleId;
    }

    /**
     * @param reportArticleId
     */
    public void setReportArticleId(String reportArticleId) {
        this.reportArticleId = reportArticleId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return report_content
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * @param reportContent
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
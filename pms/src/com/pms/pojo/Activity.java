package com.pms.pojo;

import java.util.Date;

public class Activity {
    private Integer activityId;

    private String activityContent;

    private Date activityTime;

    private Integer ownersId;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }
}
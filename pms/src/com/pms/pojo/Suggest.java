package com.pms.pojo;

import java.util.Date;

public class Suggest {
    private Integer suggestId;

    private String suggestContent;

    private Date suggestTime;

    private Date suggestHandleTime;

    private String suggestHandleResult;

    private Integer ownersId;

    private Integer adminId;

    public Integer getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(Integer suggestId) {
        this.suggestId = suggestId;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent == null ? null : suggestContent.trim();
    }

    public Date getSuggestTime() {
        return suggestTime;
    }

    public void setSuggestTime(Date suggestTime) {
        this.suggestTime = suggestTime;
    }

    public Date getSuggestHandleTime() {
        return suggestHandleTime;
    }

    public void setSuggestHandleTime(Date suggestHandleTime) {
        this.suggestHandleTime = suggestHandleTime;
    }

    public String getSuggestHandleResult() {
        return suggestHandleResult;
    }

    public void setSuggestHandleResult(String suggestHandleResult) {
        this.suggestHandleResult = suggestHandleResult == null ? null : suggestHandleResult.trim();
    }

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
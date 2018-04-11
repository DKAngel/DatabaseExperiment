package com.pms.pojo;

import java.util.Date;

public class Complain {
    private Integer complainId;

    private String complainContent;

    private Date complainTime;

    private Date complainHandleTime;

    private String complainHandleResult;

    private Integer ownersId;

    private Integer adminId;

    public Integer getComplainId() {
        return complainId;
    }

    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
    }

    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent == null ? null : complainContent.trim();
    }

    public Date getComplainTime() {
        return complainTime;
    }

    public void setComplainTime(Date complainTime) {
        this.complainTime = complainTime;
    }

    public Date getComplainHandleTime() {
        return complainHandleTime;
    }

    public void setComplainHandleTime(Date complainHandleTime) {
        this.complainHandleTime = complainHandleTime;
    }

    public String getComplainHandleResult() {
        return complainHandleResult;
    }

    public void setComplainHandleResult(String complainHandleResult) {
        this.complainHandleResult = complainHandleResult == null ? null : complainHandleResult.trim();
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
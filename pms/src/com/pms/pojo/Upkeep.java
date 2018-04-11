package com.pms.pojo;

import java.util.Date;

public class Upkeep {
    private Integer upkeepId;

    private String upkeepContent;

    private Date upkeepTime;

    private Date upkeepHandleTime;

    private String upkeepProcess;

    private String upkeepResult;

    private Integer ownersId;

    private Integer adminId;

    public Integer getUpkeepId() {
        return upkeepId;
    }

    public void setUpkeepId(Integer upkeepId) {
        this.upkeepId = upkeepId;
    }

    public String getUpkeepContent() {
        return upkeepContent;
    }

    public void setUpkeepContent(String upkeepContent) {
        this.upkeepContent = upkeepContent == null ? null : upkeepContent.trim();
    }

    public Date getUpkeepTime() {
        return upkeepTime;
    }

    public void setUpkeepTime(Date upkeepTime) {
        this.upkeepTime = upkeepTime;
    }

    public Date getUpkeepHandleTime() {
        return upkeepHandleTime;
    }

    public void setUpkeepHandleTime(Date upkeepHandleTime) {
        this.upkeepHandleTime = upkeepHandleTime;
    }

    public String getUpkeepProcess() {
        return upkeepProcess;
    }

    public void setUpkeepProcess(String upkeepProcess) {
        this.upkeepProcess = upkeepProcess == null ? null : upkeepProcess.trim();
    }

    public String getUpkeepResult() {
        return upkeepResult;
    }

    public void setUpkeepResult(String upkeepResult) {
        this.upkeepResult = upkeepResult == null ? null : upkeepResult.trim();
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
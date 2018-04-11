package com.pms.pojo;

import java.util.Date;

public class Pay {
    private Integer payId;

    private Date payTime;

    private Double payPrice;

    private Integer ownersId;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }
}
package com.pms.pojo;

public class Room {
    private Integer roomId;

    private Integer roomSize;

    private String roomPay;

    private Integer roomOwner;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomPay() {
        return roomPay;
    }

    public void setRoomPay(String roomPay) {
        this.roomPay = roomPay == null ? null : roomPay.trim();
    }

    public Integer getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(Integer roomOwner) {
        this.roomOwner = roomOwner;
    }
}
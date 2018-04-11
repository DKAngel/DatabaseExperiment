package com.pms.pojo;

public class Owner {
    private Integer ownersId;

    private String ownersEmail;

    private String ownersPassword;

    private String ownersName;

    private String ownersSex;

    private String ownersPhone;

    private Integer roomId;

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }

    public String getOwnersEmail() {
        return ownersEmail;
    }

    public void setOwnersEmail(String ownersEmail) {
        this.ownersEmail = ownersEmail == null ? null : ownersEmail.trim();
    }

    public String getOwnersPassword() {
        return ownersPassword;
    }

    public void setOwnersPassword(String ownersPassword) {
        this.ownersPassword = ownersPassword == null ? null : ownersPassword.trim();
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName == null ? null : ownersName.trim();
    }

    public String getOwnersSex() {
        return ownersSex;
    }

    public void setOwnersSex(String ownersSex) {
        this.ownersSex = ownersSex == null ? null : ownersSex.trim();
    }

    public String getOwnersPhone() {
        return ownersPhone;
    }

    public void setOwnersPhone(String ownersPhone) {
        this.ownersPhone = ownersPhone == null ? null : ownersPhone.trim();
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
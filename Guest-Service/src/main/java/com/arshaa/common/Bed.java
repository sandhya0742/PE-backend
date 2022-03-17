package com.arshaa.common;

public class Bed {

    private String guestId;
    private boolean bedStatus;
    private String bedId;

    public Bed(String guestId, boolean bedStatus, String bedId) {
        this.guestId = guestId;
        this.bedStatus = bedStatus;
        this.bedId = bedId;
    }

    public Bed() {
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public boolean isBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(boolean bedStatus) {
        this.bedStatus = bedStatus;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }
}

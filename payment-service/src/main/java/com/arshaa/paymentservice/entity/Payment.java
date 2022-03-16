package com.arshaa.paymentservice.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pId;
    private double dueAmount;
    private double securityDeposit;
    private double defaultRent;
    private String guestId;
    @Embedded
    private List<PaymentHistory> histories = new ArrayList<>();

    public Payment(int pId, double dueAmount, double securityDeposit, double defaultRent, String guestId, List<PaymentHistory> histories) {
        this.pId = pId;
        this.dueAmount = dueAmount;
        this.securityDeposit = securityDeposit;
        this.defaultRent = defaultRent;
        this.guestId = guestId;
        this.histories = histories;
    }

    public Payment() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public double getDefaultRent() {
        return defaultRent;
    }

    public void setDefaultRent(double defaultRent) {
        this.defaultRent = defaultRent;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public List<PaymentHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<PaymentHistory> histories) {
        this.histories = histories;
    }
}

package com.arshaa.paymentservice.entity;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @Id
    @GeneratedValue
    private int paymentId;
    private int guestId;
    private int amountPaid;
    private int roomRent;
    private String paymentMethod;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
    private String transactionId;
    private int dueAmount;


    public Payment(int guestId, int amountPaid, int roomRent, String paymentMethod, Date transactionDate, String transactionId, int paymentId, int dueAmount) {
        this.guestId = guestId;
        this.amountPaid = amountPaid;
        this.roomRent = roomRent;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
        this.transactionId = transactionId;
        this.paymentId = paymentId;
        this.dueAmount = dueAmount;
    }

    public Payment() {
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(int roomRent) {
        this.roomRent = roomRent;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }
}

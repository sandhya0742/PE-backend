package com.payment.common;

import java.sql.Date;

public class PayModel {
    private String transactionId;
    private Date transactionDate;
    private double dueAmount;
    private double amountPaid;
    private int paymentId;
    private String guestId;

    public PayModel() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }


    @Override
    public String toString() {
        return "PayModel{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionDate=" + transactionDate +
                ", dueAmount=" + dueAmount +
                ", amountPaid=" + amountPaid +
                ", paymentId=" + paymentId +
                ", guestId='" + guestId + '\'' +
                '}';
    }
}

package com.payment.common;

import java.util.Date;

public class RecentTransactions {
    private int paymentId;
    private double amountPaid;
    private String transactionId;
    private Date transactionDate = new Date(System.currentTimeMillis());
    private String paymentPurpose;
    private String guestId;

    public RecentTransactions(int paymentId, double amountPaid, String transactionId, Date transactionDate,
                              String paymentPurpose, String guestId) {
        super();
        this.paymentId = paymentId;
        this.amountPaid = amountPaid;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.paymentPurpose = paymentPurpose;
        this.guestId = guestId;
    }


    public int getPaymentId() {
        return paymentId;
    }


    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }


    public double getAmountPaid() {
        return amountPaid;
    }


    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
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


    public String getPaymentPurpose() {
        return paymentPurpose;
    }


    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }


    public String getGuestId() {
        return guestId;
    }


    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }


    public RecentTransactions() {
// TODO Auto-generated constructor stub
    }
}

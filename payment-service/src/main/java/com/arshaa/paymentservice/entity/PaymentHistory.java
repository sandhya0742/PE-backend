package com.arshaa.paymentservice.entity;


import javax.persistence.*;

@Entity
@Embeddable
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String transactionId;
    private String purpose;
    private double amount;

    public PaymentHistory(int paymentId, String transactionId, String purpose, double amount) {
        this.paymentId = paymentId;
        this.transactionId = transactionId;
        this.purpose = purpose;
        this.amount = amount;
    }

    public PaymentHistory() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

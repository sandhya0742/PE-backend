package com.arshaa.common;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Payment {

	private int guestId;
	private long amount;
	private String paymentTowards;
	private String paymentMethod;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date paymentDate;
	private String transactionId;
	private String paymentId;

	public Payment(int guestId, long amount, String paymentTowards, String paymentMethod, Date paymentDate,
			String transactionId, String paymentId) {
		super();
		this.guestId = guestId;
		this.amount = amount;
		this.paymentTowards = paymentTowards;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.transactionId = transactionId;
		this.paymentId = paymentId;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getPaymentTowards() {
		return paymentTowards;
	}

	public void setPaymentTowards(String paymentTowards) {
		this.paymentTowards = paymentTowards;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Payment() {
		super();
	}

}

package com.arshaa.common;

import com.arshaa.entity.Guest;

public class GuestResponse {

	private Guest guest;
	private long amount;
	private String paymentId;

	public GuestResponse(Guest guest, long amount, String paymentId) {
		super();
		this.guest = guest;
		this.amount = amount;
		this.paymentId = paymentId;
	}

	public GuestResponse() {
		super();
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}

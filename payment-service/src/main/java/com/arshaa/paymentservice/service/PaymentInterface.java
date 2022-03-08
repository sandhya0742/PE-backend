package com.arshaa.paymentservice.service;

import java.util.List;
import com.arshaa.paymentservice.entity.Payment;

public interface PaymentInterface {

    public List<Payment> getPayments();

    public Payment findPaymentByGuestId(int guestId);

    public Payment addPayment(Payment payment) ;

    public void deletePayment(int guestId);

    public Payment updateGuest(Payment payment);

}

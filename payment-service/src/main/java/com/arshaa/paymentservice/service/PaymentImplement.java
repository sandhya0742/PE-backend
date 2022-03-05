package com.arshaa.paymentservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshaa.paymentservice.entity.Payment;
import com.arshaa.paymentservice.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PaymentImplement implements PaymentInterface {

    @Autowired(required = true)
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findByGuestId(int guestId) {
        return paymentRepository.findByGuestId(guestId);
    }

    @Override
    public Payment addPayment(Payment payment) {
        payment.setPaymentId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(int guestId) {
        Payment payment = paymentRepository.getById(guestId);
        paymentRepository.delete(payment);
    }

    @Override
    public Payment updateGuest(Payment payment) {

        Payment getPayment = paymentRepository.findByGuestId(payment.getGuestId());
        getPayment.setPaymentDate(payment.getPaymentDate());
        getPayment.setPaymentMethod(payment.getPaymentMethod());
        getPayment.setPaymentTowards(payment.getPaymentTowards());
        getPayment.setTransactionId(payment.getTransactionId());
        return paymentRepository.save(getPayment);
    }

}

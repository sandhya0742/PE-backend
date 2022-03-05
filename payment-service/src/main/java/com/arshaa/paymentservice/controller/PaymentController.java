package com.arshaa.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arshaa.paymentservice.entity.Payment;
import com.arshaa.paymentservice.service.PaymentInterface;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v2")
public class PaymentController {

    @Autowired(required = true)
    private PaymentInterface paymentInterface;

    @PostMapping("/doPayment")
    public Payment doPay(@RequestBody Payment payment) {
        return paymentInterface.addPayment(payment);
    }

    @GetMapping("/{guestId}")
    public Payment findPaymentByGuestId(@PathVariable int guestId) {
        return paymentInterface.findByGuestId(guestId);
    }

    @PutMapping("/guest")
    public Payment updateGuestPayment(@RequestBody Payment payment) {
        return paymentInterface.updateGuest(payment);
    }
}

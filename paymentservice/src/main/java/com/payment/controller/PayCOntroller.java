package com.payment.controller;

import java.util.List;

import com.payment.repos.PayRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PayCOntroller {

    @Autowired
    private PaymentService serve;

    @Autowired
    private PayRepos repos;

    //http://localhost:8989/payment/addPaymentAtOnBoarding
//ADDING PAYMENT AT ONBOARDING TIME .
    @PostMapping("/addPaymentAtOnBoarding")
    public Payment addPayment(@RequestBody Payment payment) {
        return this.serve.addPayment(payment);
    }

    //http://localhost:8989/payment/updatePaymentByPaymentId/{paymentId}
//UPDATING PAYMENT BASED ON PAYMENT ID.
    @PutMapping("/updatePaymentByPaymentId/{paymentId}")
    public Payment updatePayment(@RequestBody Payment payment) {
        return this.serve.updatePayment(payment);
    }

    //	http://localhost:8989/payment/getPaymentDetail/{paymentId}
//RETRIEVE PAYMENT DETAILS BASED ON PAYMENT ID .
    @GetMapping("/getPaymentDetail/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId) {
        return this.serve.getPaymentById(paymentId);
    }

    //http://localhost:8989/payment/getAllPayments
//RETRIEVE ALL PAYMENTS AS LIST .
    @GetMapping("/getAllPayments")
    public List<Payment> getPayment() {
        return this.serve.getPayment();
    }

    // GET THE TRANSACTION HISTORY BASED ON GUESTID .
    @GetMapping("/getPaymentByGuestId/{guestId}")
    public Payment findByGuestId(@PathVariable String guestId) {
        return this.serve.getPaymentByGuestId(guestId);
    }

    //http://localhost:8989/api/getDuesAmounts/{guestId}
//FETCHING DUE AMOUNT BASED ON GUESTID .
    @GetMapping("/getDuesAmounts/{guestId}")
    public double getDueAmountByGuestId(String guestId) {
        return this.serve.getDueAmountByGuestId(guestId);
    }

    //POSTING INFORMATION OF PAYMENT BASED ON GUEST TYPE .
    @PostMapping("/addAfterOnBoard")
    public Payment addPaymentAfterOnBoar(@RequestBody Payment payment) {
        return this.serve.addPaymentAfterOnBoard(payment);
    }

    @GetMapping("/getTrasactionHistoryByGuestId/{guestId}")
    public List<Payment> findTransactionsByGuestId(@PathVariable String guestId){
        return repos.findPaymentByGuestId(guestId);
    }
}

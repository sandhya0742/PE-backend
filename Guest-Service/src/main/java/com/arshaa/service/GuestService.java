package com.arshaa.service;

import com.arshaa.common.GuestRequest;

import com.arshaa.common.GuestResponse;
import com.arshaa.common.Payment;
import com.arshaa.entity.Guest;
import com.arshaa.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GuestService implements GuestInterface {
    @Autowired(required = true)
    private GuestRepository repository;

    @Autowired
    @Lazy
    private RestTemplate template;

    @Override
    public List<Guest> getGuests() {
        return repository.findAll();
    }

    @Override
    public Guest getGuestById(int guestId) {
        return repository.findById(guestId).get();
    }

    @Override
    public GuestResponse addGuest(GuestRequest request) {
        String message = "";
        Guest guest = request.getGuest();
        Payment payment = request.getPayment();
//        java.sql.Date tSqlDate = new java.sql.Date(guest.getTransactionDate().getTime());
//        guest.setTransactionDate(tSqlDate);
        //System.out.println(guest);
        if (repository.save(guest) != null) {
            message += "Onboarded Successfully";
        } else {
            message += "Guest Data not Saved";
        }
        payment.setGuestId(repository.getById(guest.getId()).getId());
        payment.setAmountPaid(guest.getAmountPaid());
        java.sql.Date tSqldate = new java.sql.Date(guest.getTransactionDate().getTime());
        payment.setTransactionDate(tSqldate);
        Payment payResponse = template.postForObject("http://payment-service/api/v2/doPayment", payment, Payment.class);

        return new GuestResponse(payResponse.getAmountPaid(), message, payResponse.getPaymentId(), payResponse.getGuestId());
    }

    @Override
    public Guest updateGuest(int guestId) {
        Guest newGuest = repository.getById(guestId);
        // newGuest.setFirstName();
        return null;
    }

    @Override
    public void deleteGuest(int guestId) {
        Guest deleteGuest = repository.getById(guestId);
        repository.delete(deleteGuest);
    }
}

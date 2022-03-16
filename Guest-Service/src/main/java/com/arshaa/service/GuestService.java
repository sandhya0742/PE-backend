package com.arshaa.service;

import com.arshaa.common.GuestResponse;
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
    public Guest getGuestById(String guestId) {
        return repository.findById(guestId);
    }

    @Override
    public Guest addGuest(Guest guest) {
        //String message = "";
        //Guest guest = request.getGuest();
        //Payment payment = request.getPayment();
        java.sql.Date tSqlDate = new java.sql.Date(guest.getTransactionDate().getTime());
        guest.setTransactionDate(tSqlDate);
        //System.out.println(guest);
//        if (repository.save(guest) != null) {
//            message += "Guest Onboarded Successfully";
//        } else {
//            message += "Guest Data not Saved";
//        }

        //payment.setGuestId(repository.findById(guest.getId()).getId());
//        payment.setAmountPaid(guest.getAmountPaid());
//        java.sql.Date tSqldate = new java.sql.Date(guest.getTransactionDate().getTime());
//        payment.setTransactionDate(tSqldate);
//        Payment payResponse = template.postForObject("http://payment-service/payment-service/doPayment", payment, Payment.class);

        return repository.save(guest);
    }

    @Override
    public void deleteGuest(String guestId) {
        Guest deleteGuest = repository.findById(guestId);
        repository.delete(deleteGuest);
    }

    public Guest updateGuest(String guestId) {
        Guest newGuest = repository.findById(guestId);
        // newGuest.setFirstName();
        return null;
    }


}

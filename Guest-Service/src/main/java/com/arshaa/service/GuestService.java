package com.arshaa.service;

import com.arshaa.common.Bed;
import com.arshaa.common.Payment;
import com.arshaa.entity.Guest;
import com.arshaa.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
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
        String bedUri = "http://bedService/bed/updateBedStatusBydBedId";
        String payUri = "http://paymentService/payment/addPaymentAtOnBoarding";
        java.sql.Date tSqlDate = new java.sql.Date(guest.getTransactionDate().getTime());
        guest.setTransactionDate(tSqlDate);
        java.sql.Date cSqlDate = new java.sql.Date(guest.getCheckInDate().getTime());
        guest.setCheckInDate(cSqlDate);
        guest.setDueAmount(guest.getDueAmount() - guest.getAmountPaid());
        repository.save(guest);
        Bed bedReq = new Bed();
        Payment payReq = new Payment();
        //bed setting
        bedReq.setBedId(guest.getBedId());
        bedReq.setGuestId(guest.getId());
        bedReq.setDueAmount(guest.getDueAmount());
        template.put(bedUri, bedReq, Bed.class);
        //payment setting
        payReq.setGuestId(guest.getId());
        payReq.setTransactionId(guest.getTransactionId());
        payReq.setOccupancyType(guest.getOccupancyType());
        payReq.setTransactionDate(tSqlDate);
        payReq.setCheckinDate(cSqlDate);
        payReq.setAmountPaid(guest.getAmountPaid());
        payReq.setDueAmount(guest.getDueAmount());
        Payment parRes = template.postForObject(payUri, payReq, Payment.class);
        System.out.println(parRes);
        return guest;
    }

    @Override
    public Guest updateGuest(String guestId) {
        Guest newGuest = repository.findById(guestId);
//         newGuest.setFirstName();
        return null;
    }

    @Override
    public void deleteGuest(String guestId) {
        Guest deleteGuest = repository.findById(guestId);
        repository.delete(deleteGuest);
    }

}

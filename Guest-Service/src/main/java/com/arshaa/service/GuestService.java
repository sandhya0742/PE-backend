package com.arshaa.service;

import com.arshaa.common.Bed;
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
        String baseUri = "http://bedService/bed/updateBedStatusBydBedId";
        java.sql.Date tSqlDate = new java.sql.Date(guest.getTransactionDate().getTime());
        guest.setTransactionDate(tSqlDate);
        java.sql.Date cSqlDate = new java.sql.Date(guest.getCheckInDate().getTime());
        guest.setCheckInDate(cSqlDate);
        repository.save(guest);
        Bed bedReq = new Bed();
        bedReq.setBedId(guest.getBedId());
        bedReq.setGuestId(guest.getId());
        template.put(baseUri, bedReq, Bed.class);
        return guest;
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

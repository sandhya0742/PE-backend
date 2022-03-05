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
		return repository.getById(guestId);
	}

	@Override
    public GuestResponse addGuest(GuestRequest request) {
    	Guest guest = request.getGuest();
    	Payment payment = request.getPayment();
    	payment.setGuestId(guest.getId());
    	payment.setAmount(guest.getAmount());
    	Payment payResponse = template.postForObject("http://localhost:7001/api/v2/doPayment", payment, Payment.class);
    	repository.save(guest);	
        return new GuestResponse(guest, payResponse.getAmount(), payResponse.getPaymentId());
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

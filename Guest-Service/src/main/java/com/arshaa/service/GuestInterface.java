package com.arshaa.service;

import com.arshaa.common.GuestRequest;
import com.arshaa.common.GuestResponse;
import com.arshaa.entity.Guest;

import java.util.List;

public interface GuestInterface {

    public List<Guest> getGuests();

    public Guest getGuestById(int guestId);

    public GuestResponse addGuest(GuestRequest request);

    public Guest updateGuest(int guestId);

    public void deleteGuest(int guestId);
}

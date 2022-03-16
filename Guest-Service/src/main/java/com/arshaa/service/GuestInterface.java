package com.arshaa.service;

import com.arshaa.common.GuestRequest;
import com.arshaa.common.GuestResponse;
import com.arshaa.entity.Guest;

import java.util.List;

public interface GuestInterface {

    public List<Guest> getGuests();

    public Guest getGuestById(String guestId);

    public Guest addGuest(Guest guest);

    public Guest updateGuest(String guestId);

    public void deleteGuest(String guestId);
}

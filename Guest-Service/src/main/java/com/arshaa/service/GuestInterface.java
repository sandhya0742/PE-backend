package com.arshaa.service;

import com.arshaa.common.Bed;
import com.arshaa.entity.Guest;

import java.net.URISyntaxException;
import java.util.List;

public interface GuestInterface {

    public List<Guest> getGuests();

    public Guest getGuestById(String guestId);

    public Guest addGuest(Guest guest) ;

    public Guest updateGuest(String guestId);

    public void deleteGuest(String guestId);
}

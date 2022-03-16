package com.arshaa.controller;

import com.arshaa.common.GuestResponse;
import com.arshaa.entity.Guest;
import com.arshaa.service.GuestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("guest-service")
public class GuestController {

    @Autowired(required = true)
    private GuestInterface service;

    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return service.getGuests();
    }

    @PostMapping("/addGuest")
    public Guest saveGuest(@RequestBody Guest guest) {
        return service.addGuest(guest);
    }

    @GetMapping("/guest/{id}")
    public Guest getOneGuest(@PathVariable("id") String id) {
        return service.getGuestById(id);
    }

    @DeleteMapping("/guest/{id}")
    public void delete(@PathVariable("id") String id) {
        service.deleteGuest(id);
    }

}

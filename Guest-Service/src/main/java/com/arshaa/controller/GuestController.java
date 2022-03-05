package com.arshaa.controller;

import com.arshaa.common.GuestRequest;
import com.arshaa.common.GuestResponse;
import com.arshaa.entity.Guest;
import com.arshaa.service.GuestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class GuestController {

    @Autowired(required = true)
    private GuestInterface service;

    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return service.getGuests();
    }

    @PostMapping("/addGuest")
    public GuestResponse saveGuest(@RequestBody GuestRequest request) {
        return service.addGuest(request);
    }

    @GetMapping("/guest/{id}")
    public Guest getOneGuest(@PathVariable("id") int id) {
        return service.getGuestById(id);
    }

    @DeleteMapping("/guest/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteGuest(id);
    }

}

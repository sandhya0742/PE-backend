package com.arshaa.controller;

import com.arshaa.common.Bed;
import com.arshaa.entity.Guest;
import com.arshaa.service.GuestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired(required = true)
    private GuestInterface service;

    @GetMapping("/getAllGuests")
    public List<Guest> getAllGuests() {
        return service.getGuests();
    }

    @PostMapping("/addGuest")
    public Guest saveGuest(@RequestBody Guest guest) {

        return service.addGuest(guest);

    }

    @GetMapping("/getGuestByGuestId/{id}")
    public Guest getOneGuest(@PathVariable("id") String id) {
        return service.getGuestById(id);
    }

    @DeleteMapping("/deleteGuestByGuestId/{id}")
    public void delete(@PathVariable("id") String id) {
        service.deleteGuest(id);
    }

    @PutMapping("/updateDueAmount")
    public double updateDueAmount(@RequestBody Guest guest) {
        return service.updateGuest(guest);
    }

}

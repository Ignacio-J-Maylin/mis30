package com.mis30.demo.controller;


import com.mis30.demo.domain.Guest;
import com.mis30.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getAllGuests(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return guestRepository.findAll(pageable).getContent();
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
        guest.setNick(guestDetails.getNick());
        guest.setMsg(guestDetails.getMsg());
        return guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestRepository.deleteById(id);
    }
}
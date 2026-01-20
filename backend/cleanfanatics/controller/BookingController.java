package com.cleanfanatics.controller;

import com.cleanfanatics.model.Booking;
import com.cleanfanatics.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {

    private final BookingService service = new BookingService();

    // CREATE BOOKING
    @PostMapping
    public Booking createBooking(
            @RequestParam String customer,
            @RequestParam String serviceType) {
        return service.createBooking(customer, serviceType);
    }

    // ASSIGN PROVIDER
    @PostMapping("/{id}/assign")
    public Booking assignProvider(
            @PathVariable Long id,
            @RequestParam String provider) {
        return service.assignProvider(id, provider);
    }

    // START SERVICE
    @PostMapping("/{id}/start")
    public Booking startService(@PathVariable Long id) {
        return service.startService(id);
    }

    // COMPLETE SERVICE
    @PostMapping("/{id}/complete")
    public Booking completeService(@PathVariable Long id) {
        return service.completeService(id);
    }

    // CANCEL BOOKING
    @PostMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {
        return service.cancelBooking(id);
    }

    // VIEW ALL BOOKINGS
    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}

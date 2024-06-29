package com.example.rentalservice.controller;

import com.example.rentalservice.model.Booking;
import com.example.rentalservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam Long vehicleId,
                                                 @RequestParam LocalDateTime startTime,
                                                 @RequestParam LocalDateTime endTime) {
        Booking booking = bookingService.createBooking(vehicleId, startTime, endTime);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}

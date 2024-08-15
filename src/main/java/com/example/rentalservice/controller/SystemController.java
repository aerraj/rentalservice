package com.example.rentalservice.controller;

import com.example.rentalservice.model.Booking;
import com.example.rentalservice.model.Vehicle;
import com.example.rentalservice.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = systemService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = systemService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/available-vehicles")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles() {
        List<Vehicle> availableVehicles = systemService.getAvailableVehicles();
        return ResponseEntity.ok(availableVehicles);
    }
}

package com.example.rentalservice.service;

import com.example.rentalservice.model.Booking;
import com.example.rentalservice.model.Vehicle;
import com.example.rentalservice.repository.BookingRepository;
import com.example.rentalservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Booking> bookings = bookingRepository.findAll();
        return vehicleRepository.findAll().stream()
            .filter(vehicle -> bookings.stream().noneMatch(booking -> booking.getVehicle().equals(vehicle)))
            .collect(Collectors.toList());
    }
}

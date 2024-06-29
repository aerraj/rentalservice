package com.example.rentalservice.service;

import com.example.rentalservice.model.Booking;
import com.example.rentalservice.model.Vehicle;
import com.example.rentalservice.repository.BookingRepository;
import com.example.rentalservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public Booking createBooking(Long vehicleId, LocalDateTime startTime, LocalDateTime endTime) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        double price = vehicle.getPricePerHour() * (endTime.getHour() - startTime.getHour());

        Booking booking = new Booking();
        booking.setVehicle(vehicle);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setPrice(price);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}


package com.example.rentalservice.controller;

import com.example.rentalservice.dto.VehicleDTO;
import com.example.rentalservice.model.Vehicle;
import com.example.rentalservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByBranchId(@PathVariable Long branchId) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByBranchId(branchId);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/branch/{branchId}")
    public ResponseEntity<Vehicle> addVehicleToBranch(@PathVariable Long branchId, @RequestBody VehicleDTO vehicleDTO) {
        Vehicle newVehicle = vehicleService.addVehicleToBranch(branchId, vehicleDTO);
        return ResponseEntity.ok(newVehicle);
    }
}

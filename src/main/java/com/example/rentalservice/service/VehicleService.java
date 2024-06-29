package com.example.rentalservice.service;

import com.example.rentalservice.dto.VehicleDTO;
import com.example.rentalservice.model.Branch;
import com.example.rentalservice.model.Vehicle;
import com.example.rentalservice.repository.BranchRepository;
import com.example.rentalservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BranchRepository branchRepository;

    public List<Vehicle> getVehiclesByBranchId(Long branchId) {
        return vehicleRepository.findByBranchId(branchId);
    }
        public Vehicle addVehicleToBranch(Long branchId, VehicleDTO vehicleDTO) {
        Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new IllegalArgumentException("Branch not found"));
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDTO.getType());
        vehicle.setPricePerHour(vehicleDTO.getPricePerHour());
        vehicle.setBranch(branch);
        return vehicleRepository.save(vehicle);
    }
}

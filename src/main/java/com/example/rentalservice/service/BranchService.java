package com.example.rentalservice.service;

import com.example.rentalservice.model.Branch;
import com.example.rentalservice.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch addBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}

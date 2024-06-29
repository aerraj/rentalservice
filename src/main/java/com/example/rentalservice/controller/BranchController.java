package com.example.rentalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rentalservice.model.Branch;
import com.example.rentalservice.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch) {
        Branch newBranch = branchService.addBranch(branch);
        return ResponseEntity.ok(newBranch);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches() {
        List<Branch> branches = branchService.getAllBranches();
        return ResponseEntity.ok(branches);
    }
}

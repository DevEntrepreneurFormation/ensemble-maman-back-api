package com.ensemblemaman.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.service.DonationService;

@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @GetMapping("/donations")
    public Iterable<Donation> getAllDonation(){
        return donationService.getAllDonation();
    }
}

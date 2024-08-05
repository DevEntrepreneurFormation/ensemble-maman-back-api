package com.ensemblemaman.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.service.DonationService;

@RequestMapping("/api/donations")
@RestController
public class DonationContoller {
    @Autowired
    DonationService donationService;

    @GetMapping("/toto")
    public Iterable<Donation> getAllDonations(){
        return donationService.getAllDonations();
    }

    @PutMapping("/update")
    public Donation updateOneDonation(Long id, Donation data){
        return donationService.updateDonation(id, data);
    }

    @PutMapping("/create")
    public Donation createDonation(Donation data){
        return donationService.createDonation(data);
    }

    @DeleteMapping("/create")
    public Long createDonation(Long id){
       return donationService.deleDonation(id);
    }

    @GetMapping("/one")
    public Optional<Donation> getODonations(Long id){
        return donationService.getOneDonation(id);
    }
    
}

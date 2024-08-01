package com.ensemblemaman.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.repository.DonationRepository;

@Component
public class DonationService {
    @Autowired
    DonationRepository donationRepository;

    public Iterable<Donation> getAllDonation(){
       return donationRepository.findAll();
    }
}


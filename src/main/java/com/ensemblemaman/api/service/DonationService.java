package com.ensemblemaman.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.repository.DonationRepository;

@Service
public class DonationService {
    @Autowired
    DonationRepository donationRepository;

    public Iterable<Donation> getAllDonations(){
       return donationRepository.findAll();
    }

    public Donation updateDonation(Long id, Donation data){
        donationRepository.deleteById(id);
        Donation donations = donationRepository.save(data);
        // changer la donation
        return donations;
     };

    public Donation createDonation(Donation data){
        Donation donations = donationRepository.save(data);
        return donations;
    };

    public Long deleDonation(Long id){
        donationRepository.deleteById(id);
        return id;       
    };

    public Optional<Donation> getOneDonation(Long id){
        return donationRepository.findById(id);        
    };
}
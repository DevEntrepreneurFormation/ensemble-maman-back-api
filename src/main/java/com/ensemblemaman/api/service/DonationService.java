package com.ensemblemaman.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entities.Donation;
import com.ensemblemaman.api.repository.DonationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DonationService {
    @Autowired
    DonationRepository donationRepository;

    public List<Donation> getAllDonations(){
       return donationRepository.findAll();
    }


    public Long deleDonation(Long id){
        donationRepository.deleteById(id);
        return id;       
    };

    public Donation getOneDonation(Long id){
        Optional<Donation> optionalDonation = donationRepository.findById(id);
        return optionalDonation.orElseThrow(() -> new EntityNotFoundException("La ressource n'existe pas"));
                
    };


}
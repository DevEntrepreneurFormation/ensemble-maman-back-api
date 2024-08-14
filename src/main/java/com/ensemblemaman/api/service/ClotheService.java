package com.ensemblemaman.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entities.Clothe;
import com.ensemblemaman.api.repository.DonationRepository;

@Service
public class ClotheService {
    @Autowired DonationRepository donationRepository;

    public Optional<Clothe> updateClothe(Long id, Clothe clothe){
        return donationRepository.findById(id)
        .filter(Clothe.class::isInstance)
        .map(Clothe.class::cast)
        .map(existingClothe -> {
            existingClothe.setName(clothe.getName());
            existingClothe.setImageUrl(clothe.getImageUrl());
            existingClothe.setQuantity(clothe.getQuantity());
            existingClothe.setGender(clothe.getGender());
            existingClothe.setName(clothe.getName());
            existingClothe.setSize(clothe.getSize());
            existingClothe.setState(clothe.getState());

        return donationRepository.save(existingClothe);
        });
    }

    public Clothe createClothe(Clothe data){
        System.out.println(data);
        return donationRepository.save(data);
    };

     public List<Clothe> findByClothe(){
        List<Clothe> listDonation = donationRepository.findByClothe();
        return listDonation;                
    };
    
}

package com.ensemblemaman.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.model.Clothe;
import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.model.Hygiene;
import com.ensemblemaman.api.model.Toy;
import com.ensemblemaman.api.repository.DonationRepository;

@Service
public class DonationService {
    @Autowired
    DonationRepository donationRepository;

    public Iterable<Donation> getAllDonations(){
       return donationRepository.findAll();
    }

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

   public Optional<Hygiene> updateHygiene(Long id, Hygiene hygiene) {
    return donationRepository.findById(id)
    .filter(Hygiene.class::isInstance)
    .map(Hygiene.class::cast)
    .map(existingClothe -> {
        existingClothe.setName(hygiene.getName());
        existingClothe.setImageUrl(hygiene.getImageUrl());
        existingClothe.setQuantity(hygiene.getQuantity());
        existingClothe.setGender(hygiene.getGender());
        existingClothe.setName(hygiene.getName());
        existingClothe.setDateExpiration(hygiene.getDateExpiration());
        existingClothe.setCategory(hygiene.getCategory());

    return donationRepository.save(existingClothe);
  });
   }

    public Optional<Toy> updateToy(Long id, Toy toy){
        return donationRepository.findById(id)
        .filter(Toy.class::isInstance)
        .map(Toy.class::cast)
        .map(existingToy -> {
            existingToy.setName(toy.getName());
            existingToy.setImageUrl(toy.getImageUrl());
            existingToy.setQuantity(toy.getQuantity());
            existingToy.setGender(toy.getGender());
            existingToy.setName(toy.getName());
            existingToy.setAge(toy.getAge());
            existingToy.setState(toy.getState());

        return donationRepository.save(existingToy);
      });
    }

    public Hygiene createHygieneProduct(Hygiene data){
        System.out.println(data);
        return donationRepository.save(data);
    };

    public Toy createToy(Toy data){
        System.out.println(data);
        return donationRepository.save(data);
    };

    public Clothe createClothe(Clothe data){
        System.out.println(data);
        return donationRepository.save(data);
    };

    public Long deleDonation(Long id){
        donationRepository.deleteById(id);
        return id;       
    };

    public Optional<Donation> getOneDonation(Long id){
        return donationRepository.findById(id);
                
    };
}
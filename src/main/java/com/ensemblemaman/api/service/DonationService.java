package com.ensemblemaman.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entity.Clothe;
import com.ensemblemaman.api.entity.Donation;
import com.ensemblemaman.api.entity.Hygiene;
import com.ensemblemaman.api.entity.Toy;
import com.ensemblemaman.api.repository.DonationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DonationService {
    @Autowired
    DonationRepository donationRepository;

    public List<Donation> getAllDonations(){
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
        Hygiene hygieneSaved = donationRepository.save(data);
        return hygieneSaved;
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

    public Donation getOneDonation(Long id){
        Optional<Donation> optionalDonation = donationRepository.findById(id);
        return optionalDonation.orElseThrow(() -> new EntityNotFoundException("La ressource n'existe pas"));
                
    };
}
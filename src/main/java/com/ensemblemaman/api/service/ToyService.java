package com.ensemblemaman.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entities.Toy;
import com.ensemblemaman.api.repository.DonationRepository;

@Service
public class ToyService {
    @Autowired
    DonationRepository donationRepository;
    
    public List<Toy> findByToy(){
        List<Toy> listDonation = donationRepository.findByToy();
        return listDonation;                
    };

    public Toy createToy(Toy data){
        return donationRepository.save(data);
    };
    
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
}

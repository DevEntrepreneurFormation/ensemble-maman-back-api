package com.ensemblemaman.api.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entities.Hygiene;
import com.ensemblemaman.api.repository.DonationRepository;

@Service
public class HygieneServiceImpl {

    @Autowired DonationRepository donationRepository;
    @Autowired ModelMapper modelMapper;

    public Optional<Hygiene> updateHygiene(Long id, Hygiene hygiene) {
    return donationRepository.findById(id)
    .filter(Hygiene.class::isInstance)
    .map(Hygiene.class::cast)
    .map(existingClothe -> {
        if(hygiene.getName() == null) {
            existingClothe.setName(existingClothe.getName());
        } else {
            existingClothe.setName(hygiene.getName());
        }
        existingClothe.setImageUrl(hygiene.getImageUrl());
        existingClothe.setQuantity(hygiene.getQuantity());
        existingClothe.setDateExpiration(hygiene.getDateExpiration());
        existingClothe.setCategory(hygiene.getCategory());

    return donationRepository.save(existingClothe);
   });
}

    public Hygiene createHygieneProduct(Hygiene data){
      return donationRepository.save(data);
    };


    public List<Hygiene> findByHygiene(){
        List<Hygiene> listDonation = donationRepository.findByHygiene();
        return listDonation;                
    };

    // public HygieneResponseDto convertEntityToDto(Hygiene hygiene) {
    //     return modelMapper.map(hygiene, HygieneResponseDto.class);
    // };

    // public Hygiene convertDtoToEntity(HygieneRequestDto hygieneDto) {
    //     return modelMapper.map(hygieneDto, Hygiene.class);
    // }
}

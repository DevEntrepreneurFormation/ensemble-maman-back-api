package com.ensemblemaman.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ensemblemaman.api.entities.Hygiene;

@Service
public interface HygieneService {

    Optional<Hygiene> updateHygiene();
    Hygiene createHygieneProduct();
    // HygieneResponseDto convertEntityToDto();
    // Hygiene convertDtoToEntity();
}
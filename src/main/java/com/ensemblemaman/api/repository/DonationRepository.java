package com.ensemblemaman.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ensemblemaman.api.entities.Clothe;
import com.ensemblemaman.api.entities.Donation;
import com.ensemblemaman.api.entities.Hygiene;
import com.ensemblemaman.api.entities.Toy;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
    @Query("from Hygiene")
    List<Hygiene> findByHygiene();

    @Query("from Toy")
    List<Toy> findByToy();

    @Query("from Clothe")
    List<Clothe> findByClothe();

    
}

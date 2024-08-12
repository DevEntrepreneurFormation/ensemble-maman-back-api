package com.ensemblemaman.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensemblemaman.api.entity.Donation;
@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {};
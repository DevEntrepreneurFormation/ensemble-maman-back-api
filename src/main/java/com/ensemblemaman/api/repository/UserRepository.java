package com.ensemblemaman.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensemblemaman.api.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {} 
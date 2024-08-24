package com.ensemblemaman.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensemblemaman.api.entities.File;

public interface FileRepository extends JpaRepository<File, Long> {}

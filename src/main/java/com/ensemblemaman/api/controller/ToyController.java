package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entities.Toy;
import com.ensemblemaman.api.service.ToyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("donation/toy")
public class ToyController {
    @Autowired ToyService toyService;

    @PutMapping("update/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable Long id, @Valid @RequestBody Toy donation){
       return toyService.updateToy(id, donation)
       .map(donationUpdated ->  new ResponseEntity<>(donationUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("all")
    public List<Toy> findByToy(){
        return toyService.findByToy();
    }
    
    @PostMapping("create")
    public ResponseEntity<Toy> createDonation(@Valid @RequestBody Toy data){
        Toy toy = toyService.createToy(data);
       return new ResponseEntity<>(toy, HttpStatus.CREATED);
    }

    
    
}

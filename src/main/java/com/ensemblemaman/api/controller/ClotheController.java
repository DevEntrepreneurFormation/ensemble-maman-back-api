package com.ensemblemaman.api.controller;

import java.util.List;

import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entities.Clothe;
import com.ensemblemaman.api.service.ClotheService;


import jakarta.validation.Valid;


@RestController
@RequestMapping("donation/clothe")
public class ClotheController {
    @Autowired ClotheService clotheService;

    @GetMapping("all")
    public List<Clothe> findByClothe(){
         return clotheService.findByClothe();
    }

    @PostMapping("create")
    public ResponseEntity<Clothe> createDonation(@Valid @RequestBody Clothe data){

        Clothe clothe = clotheService.createClothe(data);
       return new ResponseEntity<>(clothe, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Clothe> updateClothe(@PathVariable Long id, @Valid @RequestBody Clothe clothe){
       return clotheService.updateClothe(id, clothe)
       .map(clotheUpdated ->  new ResponseEntity<Clothe>(clotheUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build()); 
    }
}

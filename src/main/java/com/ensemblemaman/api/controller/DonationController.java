package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entity.Clothe;
import com.ensemblemaman.api.entity.Donation;
import com.ensemblemaman.api.entity.Hygiene;
import com.ensemblemaman.api.entity.Toy;
import com.ensemblemaman.api.service.DonationService;

import jakarta.validation.Valid;



@RequestMapping("donations")
@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @GetMapping("all")
    public Iterable<Donation> getAllDonations(){
      return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public Donation getOneDonation(@PathVariable Long id){
         return donationService.getOneDonation(id);
    }

    @PostMapping("/hygiene/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Hygiene createDonation(@Valid @RequestBody Hygiene data){
        return donationService.createHygieneProduct(data);
    }

    @PostMapping("/toy/create")
    public ResponseEntity<Toy> createDonation(@Valid @RequestBody Toy data){
        Toy toy = donationService.createToy(data);
       return new ResponseEntity<>(toy, HttpStatus.CREATED);
    }

    @PostMapping("/clothe/create")
    public ResponseEntity<Clothe> createDonation(@Valid @RequestBody Clothe data){
        Clothe clothe = donationService.createClothe(data);
       return new ResponseEntity<>(clothe, HttpStatus.CREATED);
    }

    @PutMapping("/clothe/update/{id}")
    public ResponseEntity<Clothe> updateClothe(@PathVariable Long id, @Valid @RequestBody Clothe clothe){
       return donationService.updateClothe(id, clothe)
       .map(clotheUpdated ->  new ResponseEntity<Clothe>(clotheUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
       
    }

    @PutMapping("/hygiene/update/{id}")
    public ResponseEntity<Hygiene> updateHygiene(@PathVariable Long id, @Valid @RequestBody Hygiene hygiene){
       return donationService.updateHygiene(id, hygiene)
       .map(hygieneUpdated ->  new ResponseEntity<>(hygieneUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
       
    }

    @PutMapping("/toy/update/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable Long id, @Valid @RequestBody Toy donation){
        System.out.print("Hygiene qshfius fiushfiuhqsf ifuhhqif iqfhuqhifhf iqhfui ");
       return donationService.updateToy(id, donation)
       .map(donationUpdated ->  new ResponseEntity<>(donationUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
    }

 
    @DeleteMapping("/delete")
    public ResponseEntity<?>createDonation(@RequestParam(name="id") Long id){
       Long idDelete = donationService.deleDonation(id);
       return new ResponseEntity<>(idDelete + " a bien été supprimé", HttpStatus.OK);
    }  

    @GetMapping("/testing")
    public List<String> getTesting(){
        return List.of("Api de test");
    }
}

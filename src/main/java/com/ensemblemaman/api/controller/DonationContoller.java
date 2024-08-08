package com.ensemblemaman.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.model.Clothe;
import com.ensemblemaman.api.model.Donation;
import com.ensemblemaman.api.model.Hygiene;
import com.ensemblemaman.api.model.Toy;
import com.ensemblemaman.api.service.DonationService;

@RequestMapping("/api/donations")
@RestController
public class DonationContoller {
    @Autowired
    DonationService donationService;

    @GetMapping("")
    public Iterable<Donation> getAllDonations(){
        return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getOneDonation(@PathVariable Long id){
         return donationService.getOneDonation(id)
         .map(data -> ResponseEntity.ok(data))
         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create/hygiene")
    public ResponseEntity<Hygiene> createDonation(@RequestBody Hygiene data){
        Hygiene donation = donationService.createHygieneProduct(data);
       // une autre maniere de renvoyer les reponses
       return new ResponseEntity<>(donation, HttpStatus.CREATED);
    }

    @PostMapping("/create/toy")
    public ResponseEntity<Toy> createDonation(@RequestBody Toy data){
        Toy toy = donationService.createToy(data);
       // une autre maniere de renvoyer les reponses
       return new ResponseEntity<>(toy, HttpStatus.CREATED);
    }

    @PostMapping("/create/clothe")
    public ResponseEntity<Clothe> createDonation(@RequestBody Clothe data){
        Clothe clothe = donationService.createClothe(data);
       // une autre maniere de renvoyer les reponses
       return new ResponseEntity<>(clothe, HttpStatus.CREATED);
    }

    @PutMapping("/update/clothe/{id}")
    public ResponseEntity<Clothe> updateClothe(@PathVariable Long id, @RequestBody Clothe clothe){
       return donationService.updateClothe(id, clothe)
       .map(clotheUpdated ->  new ResponseEntity<Clothe>(clotheUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
       
    }

    @PutMapping("/update/hygiene/{id}")
    public ResponseEntity<Hygiene> updateHygiene(@PathVariable Long id, @RequestBody Hygiene hygiene){
       return donationService.updateHygiene(id, hygiene)
       .map(hygieneUpdated ->  new ResponseEntity<>(hygieneUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
       
    }

    @PutMapping("/update/toy/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable Long id, @RequestBody Toy donation){
        System.out.print("Hygiene qshfius fiushfiuhqsf ifuhhqif iqfhuqhifhf iqhfui ");
       return donationService.updateToy(id, donation)
       .map(donationUpdated ->  new ResponseEntity<>(donationUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
       
        // return donationService.updateDonation(id, data);
    }

 
    @DeleteMapping("/delete")
    public ResponseEntity<?>createDonation(@RequestParam(name="id") Long id){
       Long idDelete = donationService.deleDonation(id);
       return new ResponseEntity<>("${idDelete} a bien été supprimé", HttpStatus.OK);


    }

    
}

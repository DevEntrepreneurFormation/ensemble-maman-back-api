package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entities.Donation;
import com.ensemblemaman.api.service.DonationService;



@RequestMapping("donations")
@RestController
//@Validated
//@CrossOrigin
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

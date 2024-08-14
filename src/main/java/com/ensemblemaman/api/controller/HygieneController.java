package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entities.Hygiene;
import com.ensemblemaman.api.service.HygieneServiceImpl;
import com.ensemblemaman.api.validations.ValidationGroups.OnCreateHygiene;
import com.ensemblemaman.api.validations.ValidationGroups.OnUpdateHygiene;

@RestController
@RequestMapping("donation/hygiene")
public class HygieneController {
    @Autowired
    HygieneServiceImpl hygieneService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Hygiene createDonation(@Validated(OnCreateHygiene.class) @RequestBody Hygiene data){
        Hygiene saved = hygieneService.createHygieneProduct(data);
        return saved;
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Hygiene> updateHygiene(@PathVariable Long id, @Validated(OnUpdateHygiene.class) @RequestBody Hygiene hygiene){
       return hygieneService.updateHygiene(id, hygiene)
       .map(hygieneUpdated ->  new ResponseEntity<>(hygieneUpdated, HttpStatus.OK))
       .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("all")
    public List<Hygiene> findByHygiene(){
         return hygieneService.findByHygiene();
    }
    
}

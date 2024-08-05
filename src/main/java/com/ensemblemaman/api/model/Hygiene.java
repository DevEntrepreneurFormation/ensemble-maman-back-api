package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.HygieneCategoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
@Entity
@DiscriminatorValue("HYGIENE")
public class Hygiene extends Donation {
    @Column(name = "date_expiration")
    public String dateExpiration;
    
    @Enumerated(EnumType.STRING)
    public HygieneCategoryEnum category;
}

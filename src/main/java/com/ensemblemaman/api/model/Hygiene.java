package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.HygieneCategoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
@DiscriminatorValue("HYGIENE")
@EqualsAndHashCode(callSuper = true)
public class Hygiene extends Donation {
    @Column(name = "date_expiration", nullable = false)
    public String dateExpiration;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    public HygieneCategoryEnum category;
}

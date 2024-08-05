package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.AgeEnum;
import com.ensemblemaman.api.model.ConstantDonation.StateEnum;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Data
@Entity
@DiscriminatorValue("TOY")
public class Toy  extends Donation{
    @Enumerated(EnumType.STRING)
    public StateEnum state;

    @Enumerated(EnumType.STRING)
    public AgeEnum age;
}

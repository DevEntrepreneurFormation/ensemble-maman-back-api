package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.AgeEnum;
import com.ensemblemaman.api.model.ConstantDonation.StateEnum;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity
@DiscriminatorValue("TOY")
public class Toy  extends Donation{
    public StateEnum state;
    public AgeEnum age;
}

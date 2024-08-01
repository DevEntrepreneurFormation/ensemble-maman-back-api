package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.SizeEnum;
import com.ensemblemaman.api.model.ConstantDonation.StateEnum;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity
@DiscriminatorValue("CLOTHE")
public class Clothe extends Donation {
    public StateEnum state;
    public SizeEnum size;
}

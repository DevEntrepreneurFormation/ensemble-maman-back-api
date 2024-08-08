package com.ensemblemaman.api.model;


import com.ensemblemaman.api.model.ConstantDonation.SizeEnum;
import com.ensemblemaman.api.model.ConstantDonation.StateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("CLOTHE")
@EqualsAndHashCode(callSuper = true)
public class Clothe extends Donation {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public StateEnum state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public SizeEnum size;
}

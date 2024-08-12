package com.ensemblemaman.api.entity;

import com.ensemblemaman.api.model.HygieneCategoryEnum;
import com.ensemblemaman.api.validations.ValueOfEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("HYGIENE")
@EqualsAndHashCode(callSuper = true)
public class Hygiene extends Donation {
    @Column(name = "date_expiration")
    @NotNull(message="Ce champ est obligatoire")
    public String dateExpiration;

    @ValueOfEnum(enumClass= HygieneCategoryEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    public String category;
}

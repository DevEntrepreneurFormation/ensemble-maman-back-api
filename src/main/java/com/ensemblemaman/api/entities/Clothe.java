package com.ensemblemaman.api.entities;

import com.ensemblemaman.api.model.GenderEnum;
import com.ensemblemaman.api.model.SizeEnum;
import com.ensemblemaman.api.model.StateEnum;
import com.ensemblemaman.api.validations.ValueOfEnum;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CLOTHE")
@EqualsAndHashCode(callSuper = true)
public class Clothe extends Donation {

    @NotNull(message="Ce champ est obligatoire")
    @ValueOfEnum(enumClass= StateEnum.class)
    @NotBlank(message="Ce champ ne doit pas être vide")
    public String state;

    @NotNull(message="Ce champ est obligatoire")
    @NotBlank(message="Ce champ ne doit pas être vide")
    @ValueOfEnum(enumClass= SizeEnum.class)
    public String size;

    @NotNull(message="Ce champ est obligatoire")
    @NotBlank(message="Ce champ ne doit pas être vide")

    @ValueOfEnum(enumClass= GenderEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    @NotBlank(message="Ce champ ne doit pas être vide")
    public String gender;
}

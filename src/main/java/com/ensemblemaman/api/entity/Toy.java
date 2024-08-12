package com.ensemblemaman.api.entity;

import com.ensemblemaman.api.model.AgeEnum;
import com.ensemblemaman.api.model.StateEnum;
import com.ensemblemaman.api.validations.ValueOfEnum;
import com.ensemblemaman.api.model.GenderEnum;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@DiscriminatorValue("TOY")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Toy  extends Donation{
    @ValueOfEnum(enumClass=StateEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    public String state;

    @ValueOfEnum(enumClass=AgeEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    public String age;

    @NotNull(message="Ce champ est obligatoire")
    @ValueOfEnum(enumClass= GenderEnum.class)
    public String gender;
}

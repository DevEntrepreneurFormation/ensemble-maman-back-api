package com.ensemblemaman.api.entities;

import com.ensemblemaman.api.model.AgeEnum;
import com.ensemblemaman.api.model.HygieneCategoryEnum;
import static com.ensemblemaman.api.validations.ValidationsRegex.FORMAT_DATE;

import com.ensemblemaman.api.validations.ValidationGroups.OnCreateHygiene;
import com.ensemblemaman.api.validations.ValidationGroups.OnCreateToy;
import com.ensemblemaman.api.validations.ValueOfEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(
        regexp = FORMAT_DATE,
        message = "Ce champ doit être sous la forme \"yyyy-MM-dd'T'HH:mm:ss.SSSXXX\" (ISO)"
        )
    String dateExpiration;

    @ValueOfEnum(enumClass= HygieneCategoryEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    public String category;

    @ValueOfEnum(enumClass=AgeEnum.class)
    @NotNull(message="Ce champ est obligatoire")
    @NotBlank(message="Ce champ ne doit pas être vide")
    public String age;

}

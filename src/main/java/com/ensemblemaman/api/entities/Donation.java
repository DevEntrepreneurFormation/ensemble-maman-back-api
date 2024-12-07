package com.ensemblemaman.api.entities;

import com.ensemblemaman.api.model.AgeEnum;
import com.ensemblemaman.api.validations.ValueOfEnum;
import com.ensemblemaman.api.validations.ValidationGroups.OnCreateClothe;
import com.ensemblemaman.api.validations.ValidationGroups.OnCreateHygiene;
import com.ensemblemaman.api.validations.ValidationGroups.OnCreateToy;
import com.ensemblemaman.api.validations.ValidationGroups.OnUpdateClothe;
import com.ensemblemaman.api.validations.ValidationGroups.OnUpdateHygiene;
import com.ensemblemaman.api.validations.ValidationGroups.OnUpdateToy;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "donation")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_donation", discriminatorType = DiscriminatorType.STRING)
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    public Long id;

    @Column(nullable=false)
    @NotBlank(message="Ce champ ne doit pas être vide",
    groups = {
        OnCreateHygiene.class, OnCreateToy.class, OnCreateClothe.class,
        }
        )
    @Size(min = 3, max = 100, message = "Ce champ doit comporter entre 3 et 100 caractères",groups = {
        OnCreateHygiene.class, OnCreateToy.class, OnCreateClothe.class,
        OnUpdateHygiene.class, OnUpdateClothe.class, OnUpdateToy.class,
    })
    public String name;

    @Column(name="image_url")
    @NotNull(message="Ce champ est obligatoire")
    @NotBlank(message="Ce champ ne doit pas être vide")
    public String imageUrl;

    @Column(nullable=false)
    @NotNull(message="Ce champ est obligatoire")
    @Min(1)
    public Integer quantity;

    @Transient
    public String getTypeDonation() {
        if (this instanceof Clothe) {
            return "CLOTHE";
        } else if (this instanceof Hygiene) {
            return "HYGIENE";
        }
        else if (this instanceof Toy) {
            return "TOY";
        }
        return "UNKNOWN";
    }
}
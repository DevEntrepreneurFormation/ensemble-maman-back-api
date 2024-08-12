package com.ensemblemaman.api.entity;

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
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message="Ce champ est obligatoire")
    public String name;

    @Column(name="image_url")
    @NotNull(message="Ce champ est obligatoire")
    public String imageUrl;

    @Column(nullable=false)
    @NotNull(message="Ce champ est obligatoire")
    @Min(1)
    public int quantity;

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
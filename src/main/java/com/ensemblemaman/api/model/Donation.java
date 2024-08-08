
package com.ensemblemaman.api.model;

import com.ensemblemaman.api.model.ConstantDonation.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "donation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_donation", discriminatorType = DiscriminatorType.STRING)
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable=false)
    public String name;

    @Column(name="image_url", nullable = false)
    public String imageUrl;

    @Column(nullable=false)
    public int quantity;

    @Enumerated(EnumType.STRING)
    public GenderEnum gender;

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


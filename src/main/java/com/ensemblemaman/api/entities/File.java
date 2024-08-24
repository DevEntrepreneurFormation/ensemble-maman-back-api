package com.ensemblemaman.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    public Long id;

    private String name;
    private String type;

    @Lob
    private byte[] data;

}

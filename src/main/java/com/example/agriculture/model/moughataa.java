package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class moughataa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    @ManyToOne
    private wilaya wilaya;
    @OneToMany(
            mappedBy = "moughataa",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<commune> communeList= new ArrayList<>();
}

package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_region;
    private String nom;
    private String surface;
    @OneToMany(
            mappedBy = "region",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<publication> publicationList= new ArrayList<>();
}

package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            mappedBy = "commune",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<publication> publicationList= new ArrayList<>();
    @Column(unique = true)
   private String nom;
    @ManyToOne
    private moughataa moughataa;
}

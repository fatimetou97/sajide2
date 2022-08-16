package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class wilaya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    @OneToMany(
            mappedBy = "wilaya",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<moughataa> moughataaList= new ArrayList<>();
}

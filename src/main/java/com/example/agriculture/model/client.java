package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_client;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "password")
    private String password;
    @OneToMany(
            mappedBy = "client"
          //  cascade = CascadeType.ALL,
            //orphanRemoval = true
    )
    List<commande> commandeList= new ArrayList<>();
}

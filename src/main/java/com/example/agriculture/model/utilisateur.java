package com.example.agriculture.model;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_user;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name="id_role")
    private role user_role;
    @OneToMany(
            mappedBy = "utilisateur",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<publication> publicationList= new ArrayList<>();
    @OneToMany(
            mappedBy = "utilisateur",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<produit> produitList= new ArrayList<>();

}

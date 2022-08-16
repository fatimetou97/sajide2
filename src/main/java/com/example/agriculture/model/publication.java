package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_publication;
    private String description;
    private boolean est_affiche;
    private Date date_publication;
    private String image;

    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name="id_commune")
    private commune commune;
}

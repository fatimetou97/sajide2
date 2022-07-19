package com.example.agriculture.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data

public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_role;
    @Column(name = "role")
    private String role;
    @OneToMany(
            mappedBy = "user_role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<utilisateur> utilisateurList = new ArrayList<>();
}

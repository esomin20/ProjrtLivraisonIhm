package com.example.projrtlivraisonihm.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livreur;
    private String nom;
    private String prenom;
    private String ville ;
    private String CIN;
    private String adresse;
    private Long telephone;
    private String email;
    private Date dateNaissance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private admin admin;

    @OneToMany(mappedBy = "livreur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<commande> commandes;

    @OneToOne(mappedBy = "livreur", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private compte compte;

}

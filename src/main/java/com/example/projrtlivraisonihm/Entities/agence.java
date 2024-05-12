package com.example.projrtlivraisonihm.Entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdmin", nullable = false)
    private admin admin;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<client> clients;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<commande> commandes;


    @OneToOne(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private compte compte;

}

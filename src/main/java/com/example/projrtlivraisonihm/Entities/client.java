package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private String cin; // Renamed from CIN
    private String adresse;
    private Long telephone;

    @Column(unique = true)
    private String email;

    private Date dateNaissance;


    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private compte compte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgence", nullable = false)
    private agence agence;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<commande> commandes;



}

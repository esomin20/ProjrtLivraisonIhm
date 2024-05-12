package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private String nom;
    private Date dateMin;
    private Date dateMax;
    private boolean affecte;

    @Enumerated(value = EnumType.STRING)
    private TypeCommande type;
    private boolean accomplie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdmin", nullable = false)
    private admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLivreur", nullable = false)
    private livreur livreur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgence", nullable = false)
    private agence agence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idClient", nullable = false)
    private client client;


}

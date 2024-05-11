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
    private Long id_commande;
    private String nom;
    private Date date_min;
    private Date date_max;
    private boolean affecté;

    @Enumerated(value = EnumType.STRING)
    private TypeCommande type;
    private boolean accomplie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livreur", nullable = false)
    private livreur livreur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agence", nullable = false)
    private agence agence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private client client;


}

package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
@Entity
public class commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commande;
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

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_min() {
        return date_min;
    }

    public void setDate_min(Date date_min) {
        this.date_min = date_min;
    }

    public Date getDate_max() {
        return date_max;
    }

    public void setDate_max(Date date_max) {
        this.date_max = date_max;
    }

    public boolean isAffecté() {
        return affecté;
    }

    public void setAffecté(boolean affecté) {
        this.affecté = affecté;
    }

    public TypeCommande getType() {
        return type;
    }

    public void setType(TypeCommande type) {
        this.type = type;
    }

    public boolean isAccomplie() {
        return accomplie;
    }

    public void setAccomplie(boolean accomplie) {
        this.accomplie = accomplie;
    }

    public commande() {
    }

    public commande(int id_commande, String nom, Date date_min, Date date_max, boolean affecté, TypeCommande type, boolean accomplie, com.example.projrtlivraisonihm.Entities.admin admin, com.example.projrtlivraisonihm.Entities.livreur livreur, com.example.projrtlivraisonihm.Entities.agence agence, com.example.projrtlivraisonihm.Entities.client client) {
        this.id_commande = id_commande;
        this.nom = nom;
        this.date_min = date_min;
        this.date_max = date_max;
        this.affecté = affecté;
        this.type = type;
        this.accomplie = accomplie;
        this.admin = admin;
        this.livreur = livreur;
        this.agence = agence;
        this.client = client;
    }
}

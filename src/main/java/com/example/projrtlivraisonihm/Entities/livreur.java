package com.example.projrtlivraisonihm.Entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livreur;
    private String nom;
    private String prenom;
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

    public Long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(Long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public livreur() {
    }

    public livreur(Long id_livreur, String nom, String prenom, String CIN, String adresse, Long telephone, String email, Date dateNaissance, com.example.projrtlivraisonihm.Entities.admin admin, List<commande> commandes, com.example.projrtlivraisonihm.Entities.compte compte) {
        this.id_livreur = id_livreur;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.admin = admin;
        this.commandes = commandes;
        this.compte = compte;
    }
}

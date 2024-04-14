package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String nom;
    private String prenom;
    private String CIN;
    private String adresse;
    private Long telephone;
    private String email;
    private Date dateNaissance;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private compte compte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agence", nullable = false)
    private agence agence;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<commande> commandes;

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
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

    public client(Long id_client, String nom, String prenom, String CIN, String adresse, Long telephone, String email, Date dateNaissance, com.example.projrtlivraisonihm.Entities.compte compte, com.example.projrtlivraisonihm.Entities.agence agence, List<commande> commandes) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.compte = compte;
        this.agence = agence;
        this.commandes = commandes;
    }

    public client() {
    }
}

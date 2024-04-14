package com.example.projrtlivraisonihm.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    private String nom;
    private String prenom;
    private String CIN;
    private String adresse;
    private Long telephone;
    private String email;
    private Date dateNaissance;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> livreurs;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> agences;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> commandes;


    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
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

    public admin(Long id_admin, String nom, String prenom, String CIN, String adresse, Long telephone, String email, Date dateNaissance, List<livreur> livreurs, List<livreur> agences, List<livreur> commandes) {
        this.id_admin = id_admin;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.livreurs = livreurs;
        this.agences = agences;
        this.commandes = commandes;
    }

    public admin() {
    }
}

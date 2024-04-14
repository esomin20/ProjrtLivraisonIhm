package com.example.projrtlivraisonihm.Entities;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_agence;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private admin admin;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<client> clients;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<commande> commandes;


    @OneToOne(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private compte compte;

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public agence(int id_agence, String nom, String adresse, String telephone, String email, com.example.projrtlivraisonihm.Entities.admin admin, List<client> clients, List<commande> commandes, com.example.projrtlivraisonihm.Entities.compte compte) {
        this.id_agence = id_agence;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.admin = admin;
        this.clients = clients;
        this.commandes = commandes;
        this.compte = compte;
    }

    public agence() {
    }
}

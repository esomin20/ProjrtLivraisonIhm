package com.example.projrtlivraisonihm.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private Long telephone;
    private String email;
    private String password;
    private Date dateNaissance;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> livreurs;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> agences;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<livreur> commandes;


}

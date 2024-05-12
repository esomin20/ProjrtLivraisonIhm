package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private String login;
    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private String mdp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLivreur", nullable = false)
    private livreur livreur;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgence", nullable = false)
    private agence agence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idClient", nullable = false)
    private client client;


}

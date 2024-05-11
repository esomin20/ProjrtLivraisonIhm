package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compte;
    private String login;
    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private String mdp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livreur", nullable = false)
    private livreur livreur;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agence", nullable = false)
    private agence agence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private client client;


}

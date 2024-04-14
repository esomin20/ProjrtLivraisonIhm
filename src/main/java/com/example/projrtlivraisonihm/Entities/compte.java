package com.example.projrtlivraisonihm.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    public Long getId_compte() {
        return id_compte;
    }

    public void setId_compte(Long id_compte) {
        this.id_compte = id_compte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public compte(Long id_compte, String login, Type type, String mdp, com.example.projrtlivraisonihm.Entities.livreur livreur, com.example.projrtlivraisonihm.Entities.agence agence, com.example.projrtlivraisonihm.Entities.client client) {
        this.id_compte = id_compte;
        this.login = login;
        this.type = type;
        this.mdp = mdp;
        this.livreur = livreur;
        this.agence = agence;
        this.client = client;
    }

    public compte() {
    }
}

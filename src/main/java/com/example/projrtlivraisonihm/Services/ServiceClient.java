package com.example.projrtlivraisonihm.Services;

import com.example.projrtlivraisonihm.Repesitory.ClientRespository;
import org.springframework.stereotype.Service;

import com.example.projrtlivraisonihm.Entities.client;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
@Service
public class ServiceClient {
    private final ClientRespository clientRepository;

    @Autowired
    public ServiceClient(ClientRespository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Méthode pour trouver un client par son ID
    public client trouverClientParId(long id) {
        return clientRepository.findById(id);
    }

    // Méthode pour trouver tous les clients ayant un nom spécifique
    public List<client> trouverClientsParNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    // Méthode pour trouver tous les clients dont l'email contient un certain texte
    public List<client> trouverClientsParEmail(String texte) {
        return clientRepository.findByEmailContaining(texte);
    }

    // Méthode pour trouver tous les clients ayant un prénom spécifique
    public List<client> trouverClientsParPrenom(String prenom) {
        return clientRepository.findByPrenom(prenom);
    }

    // Méthode pour trouver tous les clients nés après une certaine date
    public List<client> trouverClientsNeApres(Date date) {
        return clientRepository.findByDateNaissanceAfter(date);
    }

    // Méthode pour trouver tous les clients ayant un certain nom et un certain prénom
    public List<client> trouverClientsParNomEtPrenom(String nom, String prenom) {
        return clientRepository.findByNomAndPrenom(nom, prenom);
    }

    // Méthode pour trouver tous les clients desservis par un livreur spécifique
    public List<client> trouverClientsDesservisParLivreur(livreur livr) {
        return clientRepository.getClientsDesservisParLivreur(livr);
    }

    // testtt

}

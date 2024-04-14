package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface LivreurRepository extends JpaRepository<livreur, Long> {
    // Trouver un livreur par son ID
    livreur findById(long id);

    // Trouver tous les livreurs ayant un nom spécifique
    List<livreur> findByNom(String nom);

    // Trouver tous les livreurs dont l'email contient un certain texte
    List<livreur> findByEmailContaining(String texte);

    // Exemples de méthodes personnalisées que vous pouvez ajouter :

    // Trouver tous les livreurs ayant un prénom spécifique
    List<livreur> findByPrenom(String prenom);

    // Trouver tous les livreurs nés après une certaine date
    List<livreur> findByDateNaissanceAfter(Date date);

    // Trouver tous les livreurs ayant un certain nom et un certain prénom
    List<livreur> findByNomAndPrenom(String nom, String prenom);

    // méthode personnalisée pour trouver toutes les commandes associées à un livreur spécifique
    List<commande> findByLivreur(livreur livr);

}

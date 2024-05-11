package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.TypeCommande;
import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface CommandeRepository extends JpaRepository<commande, Long> {
    // Trouver une commande par son ID
    commande findById(int id);

    // Trouver toutes les commandes ayant un nom spécifique
    List<commande> findByNom(String nom);

    // Trouver toutes les commandes dont la date minimum est après une certaine date
    List<commande> findByDateMinAfter(Date date);

    // Trouver toutes les commandes affectées ou non
    List<commande> findByAffecte(boolean affecte);

    // Exemples de méthodes personnalisées que vous pouvez ajouter :

    // Trouver toutes les commandes accomplies ou non
    List<commande> findByAccomplie(boolean accomplie);

    // Trouver toutes les commandes d'un type spécifique
    List<commande> findByType(TypeCommande type);

    // Trouver toutes les commandes associées à un client spécifique
    List<commande> findByClient_IdClient(Long idClient);

    // méthode personnalisée pour obtenir la liste des commandes effectuées par un client spécifique
    List<commande> findByClient(commande client);


}

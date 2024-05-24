package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LivreurRepository extends JpaRepository<livreur, Long> {

    // Trouver tous les livreurs ayant un nom spécifique
    List<livreur> findByNom(String nom);

    // Trouver tous les livreurs par leur ville
    List<livreur> findByVille(String ville);

    // Trouver tous les livreurs par leur cin
    List<livreur> findByCin(String cin);

    // Trouver tous les livreurs par leur adresse
    List<livreur> findByAdresse(String adresse);

    // Trouver tous les livreurs par leur email
    List<livreur> findByEmail(String email);

    // Trouver tous les livreurs par leur date de naissance
    List<livreur> findByDateNaissance(Date dateNaissance);


    // Trouver tous les livreurs par leur compte
    List<livreur> findByCompte(compte compte);

    // Vous pouvez définir d'autres méthodes de requête personnalisées ici
}

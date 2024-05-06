package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.admin;
import com.example.projrtlivraisonihm.Entities.livreur;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository

public interface AdminRepository extends JpaRepository<admin,Long> {
    Optional<admin> findById(Long id_admin);
    admin findByCin(String CIN);
    admin findByNom(String nom);
    admin findByEmail(String email);


    // Méthode pour affecter une commande à un livreur

}

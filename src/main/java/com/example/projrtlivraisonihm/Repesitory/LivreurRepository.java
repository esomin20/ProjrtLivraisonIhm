package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface LivreurRepository extends JpaRepository<livreur, Long> {
    // You can define custom queries here if needed
}
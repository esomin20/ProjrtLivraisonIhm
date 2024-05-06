package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.agence;
import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Entities.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<agence, Long> {


}

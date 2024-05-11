package com.example.projrtlivraisonihm.Repesitory;
import com.example.projrtlivraisonihm.Entities.agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgenceRepository extends JpaRepository<agence, Long> {
    Optional<agence> findByEmail(String email);
    Optional<agence> findByNom(String nom);
}

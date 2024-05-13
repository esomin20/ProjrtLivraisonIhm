package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<compte, Long> {
    Optional<compte> findByLogin(String login);  // Trouver un compte par son login
}

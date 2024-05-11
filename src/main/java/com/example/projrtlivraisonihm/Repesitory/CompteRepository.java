package com.example.projrtlivraisonihm.Repesitory;

import com.example.projrtlivraisonihm.Entities.compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<compte, Long> {

    Optional<compte> findByLogin(String login);
}

package com.example.projrtlivraisonihm.Services.livreur;

import com.example.projrtlivraisonihm.Entities.livreur;
import com.example.projrtlivraisonihm.Repesitory.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLivreur {

    private final LivreurRepository livreurRepository;

    @Autowired
    public ServiceLivreur(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    public List<livreur> findAllLivreurs() {
        return livreurRepository.findAll();
    }

    public Optional<livreur> findLivreurById(Long id) {
        return livreurRepository.findById(id);
    }

    public livreur saveLivreur(livreur livreur) {
        return livreurRepository.save(livreur);
    }

    public void deleteLivreur(Long id) {
        livreurRepository.deleteById(id);
    }

    // Additional business logic and method implementations can go here
}
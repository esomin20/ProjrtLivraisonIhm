package com.example.projrtlivraisonihm.controller;


import com.example.projrtlivraisonihm.Entities.livreur;
import com.example.projrtlivraisonihm.Services.livreur.ServiceLivreur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livreurs")
public class LivreurController {

    private final ServiceLivreur livreurService;

    @Autowired
    public LivreurController(ServiceLivreur livreurService) {
        this.livreurService = livreurService;
    }

    @GetMapping
    public List<livreur> getAllLivreurs() {
        return livreurService.findAllLivreurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<livreur> getLivreurById(@PathVariable Long id) {
        return livreurService.findLivreurById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public livreur createLivreur(@RequestBody livreur newLivreur) {
        return livreurService.saveLivreur(newLivreur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<livreur> updateLivreur(@PathVariable Long id, @RequestBody livreur updatedLivreur) {
        return livreurService.findLivreurById(id)
                .map(existingLivreur -> {
                    updatedLivreur.setIdLivreur(existingLivreur.getIdLivreur());
                    livreurService.saveLivreur(updatedLivreur);
                    return ResponseEntity.ok(updatedLivreur);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivreur(@PathVariable Long id) {
        if (livreurService.findLivreurById(id).isPresent()) {
            livreurService.deleteLivreur(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
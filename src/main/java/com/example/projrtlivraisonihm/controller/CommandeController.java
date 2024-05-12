package com.example.projrtlivraisonihm.controller;

import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Services.commande.ServiceCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final ServiceCommande serviceCommande;

    @Autowired
    public CommandeController(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }

    @GetMapping
    public ResponseEntity<List<commande>> getAllCommandes() {
        return ResponseEntity.ok(serviceCommande.trouverCommandesParAffecte(false));
    }

    @GetMapping("/{id}")
    public ResponseEntity<commande> getCommandeById(@PathVariable Long idCommande) {
        commande foundCommande = serviceCommande.trouverCommandeParId(idCommande);
        if (foundCommande != null) {
            return ResponseEntity.ok(foundCommande);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<commande> createCommande(@RequestBody commande newCommande) {
        commande savedCommande = serviceCommande.saveCommande(newCommande);
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<commande> updateCommande(@PathVariable Long id, @RequestBody commande updatedCommande) {
        try {
            commande command = serviceCommande.updateCommande(id, updatedCommande);
            return ResponseEntity.ok(command);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        serviceCommande.deleteCommande(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCommandes() {
        return ResponseEntity.ok(serviceCommande.countCommande());
    }

    @PostMapping("/{id_commande}/affecterClient/{id_client}")
    public ResponseEntity<commande> affecterCommandeAClient(@PathVariable Long id_commande, @PathVariable Long id_client) {
        try {
            commande updatedCommande = serviceCommande.affecterCommandeAClient(id_commande, id_client);
            return ResponseEntity.ok(updatedCommande);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{idCommande}/affecterLivreur/{idLivreur}")
    public ResponseEntity<commande> affecterCommandeALivreur(@PathVariable Long idCommande, @PathVariable Long idLivreur) {
        try {
            commande updatedCommande = serviceCommande.affecterCommandeALivreur(idCommande, idLivreur);
            return ResponseEntity.ok(updatedCommande);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

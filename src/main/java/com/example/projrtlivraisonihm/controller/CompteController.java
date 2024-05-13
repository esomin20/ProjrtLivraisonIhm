package com.example.projrtlivraisonihm.controller;

import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Services.compte.ServiceCompte;
import com.example.projrtlivraisonihm.Services.compte.CompteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final ServiceCompte serviceCompte;

    @Autowired
    public CompteController(ServiceCompte serviceCompte) {
        this.serviceCompte = serviceCompte;
    }

    @GetMapping
    public ResponseEntity<List<compte>> getAllComptes() {
        List<compte> comptes = serviceCompte.getAllComptes();
        return ResponseEntity.ok(comptes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<compte> getCompteById(@PathVariable Long id) {
        try {
            compte compte = serviceCompte.getCompte(id);
            return ResponseEntity.ok(compte);
        } catch (CompteNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<compte> createCompte(@RequestBody compte compte) {
        compte savedCompte = serviceCompte.saveCompte(compte);
        return new ResponseEntity<>(savedCompte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<compte> updateCompte(@PathVariable Long id, @RequestBody compte updatedCompte) {
        try {
            serviceCompte.updateCompte(id, updatedCompte);
            return ResponseEntity.ok(updatedCompte);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        serviceCompte.deleteCompte(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String login, @RequestParam String password) {
        boolean isAuthenticated = serviceCompte.authenticate(login, password);
        return isAuthenticated ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
/*import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Services.compte.ServiceCompte;
import com.example.projrtlivraisonihm.Services.compte.CompteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final ServiceCompte serviceCompte;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CompteController(ServiceCompte serviceCompte, BCryptPasswordEncoder passwordEncoder) {
        this.serviceCompte = serviceCompte;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<compte>> getAllComptes() {
        List<compte> comptes = serviceCompte.getAllComptes();
        return ResponseEntity.ok(comptes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<compte> getCompteById(@PathVariable Long id) {
        try {
            compte compte = serviceCompte.getCompte(id);
            return ResponseEntity.ok(compte);
        } catch (CompteNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<compte> createCompte(@RequestBody compte compte) {
        compte.setMdp(passwordEncoder.encode(compte.getMdp())); // Encrypt the password before saving
        compte savedCompte = serviceCompte.saveCompte(compte);
        return new ResponseEntity<>(savedCompte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<compte> updateCompte(@PathVariable Long id, @RequestBody compte updatedCompte) {
        try {
            updatedCompte.setMdp(passwordEncoder.encode(updatedCompte.getMdp())); // Encrypt the new password
            serviceCompte.updateCompte(id, updatedCompte);
            return ResponseEntity.ok(updatedCompte);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        serviceCompte.deleteCompte(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String login, @RequestParam String password) {
        boolean isAuthenticated = serviceCompte.authenticate(login, password);
        return isAuthenticated ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
*/
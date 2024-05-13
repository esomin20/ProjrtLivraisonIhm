package com.example.projrtlivraisonihm.Services.compte;

import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Repesitory.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompte {
    private final CompteRepository compteRepository;

    @Autowired
    public ServiceCompte(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public List<compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public compte getCompte(Long id) throws CompteNotFoundException {
        return compteRepository.findById(id).orElseThrow(() -> new CompteNotFoundException("Compte introuvable avec l'ID : " + id));
    }

    public compte saveCompte(compte compte) {
        // Assume that the password is already handled appropriately
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public void updateCompte(Long id, compte updatedCompte) {
        compteRepository.findById(id).map(existingCompte -> {
            existingCompte.setLogin(updatedCompte.getLogin());
            existingCompte.setMdp(updatedCompte.getMdp()); // Directly set the password without encryption
            existingCompte.setType(updatedCompte.getType());
            // Update relationships as necessary
            existingCompte.setLivreur(updatedCompte.getLivreur());
            existingCompte.setAgence(updatedCompte.getAgence());
            existingCompte.setClient(updatedCompte.getClient());
            return compteRepository.save(existingCompte);
        }).orElseThrow(() -> new IllegalArgumentException("Compte non trouvé pour l'ID : " + id));
    }

    // Simple authentication check without encryption
    public boolean authenticate(String enteredLogin, String enteredPassword) {
        Optional<compte> compteOpt = compteRepository.findByLogin(enteredLogin);
        return compteOpt.isPresent() && compteOpt.get().getMdp().equals(enteredPassword);
    }
}


/*package com.example.projrtlivraisonihm.Services.compte;

import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Repesitory.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.projrtlivraisonihm.Services.compte.SecurityConfig;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompte {
    private final CompteRepository compteRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ServiceCompte(CompteRepository compteRepository, BCryptPasswordEncoder passwordEncoder) {
        this.compteRepository = compteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public compte getCompte(Long id) throws CompteNotFoundException {
        return compteRepository.findById(id).orElseThrow(() -> new CompteNotFoundException("Compte introuvable avec l'ID : " + id));
    }

    public compte saveCompte(compte compte) {
        compte.setMdp(passwordEncoder.encode(compte.getMdp())); // Encrypt the password
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public void updateCompte(Long id, compte updatedCompte) {
        compteRepository.findById(id).map(existingCompte -> {
            existingCompte.setLogin(updatedCompte.getLogin());
            existingCompte.setMdp(passwordEncoder.encode(updatedCompte.getMdp())); // Encrypt the new password
            existingCompte.setType(updatedCompte.getType());
            // Update relationships as necessary
            existingCompte.setLivreur(updatedCompte.getLivreur());
            existingCompte.setAgence(updatedCompte.getAgence());
            existingCompte.setClient(updatedCompte.getClient());
            return compteRepository.save(existingCompte);
        }).orElseThrow(() -> new IllegalArgumentException("Compte non trouvé pour l'ID : " + id));
    }

    public boolean authenticate(String enteredLogin, String enteredPassword) {
        Optional<compte> compteOpt = compteRepository.findByLogin(enteredLogin);
        return compteOpt.isPresent() && passwordEncoder.matches(enteredPassword, compteOpt.get().getMdp());
    }
}*/
package com.example.projrtlivraisonihm.Services.compte;

import com.example.projrtlivraisonihm.Entities.compte;
import com.example.projrtlivraisonihm.Repesitory.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ServiceCompte  {
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
        Optional<compte> result = compteRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CompteNotFoundException("Compte introuvable avec l'ID : " + id);
    }

    public compte saveCompte(compte compte) {
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public void updateCompte(Long id, compte updatedCompte) {
        Optional<compte> existingCompteOptional = compteRepository.findById(id);

        if (existingCompteOptional.isPresent()) {
            compte existingCompte = existingCompteOptional.get();
            existingCompte.setLogin(updatedCompte.getLogin());  // mise à jour du login
            existingCompte.setMdp(updatedCompte.getMdp());      // mise à jour du mot de passe
            existingCompte.setType(updatedCompte.getType());    // mise à jour du type de compte

            // Mise à jour des relations (si nécessaire)
            existingCompte.setLivreur(updatedCompte.getLivreur());
            existingCompte.setAgence(updatedCompte.getAgence());
            existingCompte.setClient(updatedCompte.getClient());

            compteRepository.save(existingCompte);
        } else {
            throw new IllegalArgumentException("Compte non trouvé pour l'ID : " + id);
        }
    }
    public boolean authenticate(String enteredLogin, String enteredPassword) {
        Optional<compte> compteOpt = compteRepository.findByLogin(enteredLogin);
        return compteOpt.isPresent() && passwordEncoder.matches(enteredPassword, compteOpt.get().getMdp());
    }

}
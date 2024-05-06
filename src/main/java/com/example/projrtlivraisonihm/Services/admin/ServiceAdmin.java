package com.example.projrtlivraisonihm.Services.admin;

import com.example.projrtlivraisonihm.Entities.admin;
import com.example.projrtlivraisonihm.Entities.livreur;
import com.example.projrtlivraisonihm.Repesitory.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdmin {

    private final AdminRepository adminRepository;

    @Autowired
    public ServiceAdmin(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    // Méthode pour la connexion de l'admin (à implémenter manuellement)
    public boolean authenticate(String enteredEmail, String enteredPassword) {
        admin admin = adminRepository.findByEmail(enteredEmail);
        return admin != null && admin.getPassword().equals(enteredPassword);
    }

}
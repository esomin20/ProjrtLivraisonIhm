package com.example.projrtlivraisonihm.Services.admin;

import com.example.projrtlivraisonihm.Entities.admin;
import com.example.projrtlivraisonihm.Entities.livreur;
import com.example.projrtlivraisonihm.Repesitory.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdmin {

    @Autowired
    private final AdminRepository adminRepository;

    public ServiceAdmin(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Méthode pour la connexion de l'admin (à implémenter manuellement)
    public boolean authenticate(String enteredEmail, String enteredPassword) {
        admin admin = adminRepository.findByEmail(enteredEmail);
        return admin != null && admin.getPassword().equals(enteredPassword);
    }
    public List<admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public admin saveAdmin(admin Admin) {
        return adminRepository.save(Admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public admin updateAdmin(Long id, admin newAdmin) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setNom(newAdmin.getNom());
                    admin.setPrenom(newAdmin.getPrenom());
                    admin.setCin(newAdmin.getCin());
                    admin.setAdresse(newAdmin.getAdresse());
                    admin.setTelephone(newAdmin.getTelephone());
                    admin.setEmail(newAdmin.getEmail());
                    admin.setPassword(newAdmin.getPassword());
                    admin.setDateNaissance(newAdmin.getDateNaissance());
                    return adminRepository.save(admin);
                })
                .orElseGet(() -> {
                    newAdmin.setIdAdmin(id);
                    return adminRepository.save(newAdmin);
                });
    }

    public long countAdmin(){
        return adminRepository.count();
    }

}
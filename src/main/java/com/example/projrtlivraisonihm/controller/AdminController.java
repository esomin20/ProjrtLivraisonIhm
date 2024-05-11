package com.example.projrtlivraisonihm.controller;

import com.example.projrtlivraisonihm.Entities.admin;
import com.example.projrtlivraisonihm.Services.admin.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final ServiceAdmin serviceAdmin;

    @Autowired
    public AdminController(ServiceAdmin serviceAdmin) {
        this.serviceAdmin = serviceAdmin;
    }

    @GetMapping
    public ResponseEntity<List<admin>> getAllAdmins() {
        return ResponseEntity.ok(serviceAdmin.findAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<admin> getAdminById(@PathVariable Long id) {
        return serviceAdmin.findAdminById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<admin> createAdmin(@RequestBody admin Admin) {
        return new ResponseEntity<>(serviceAdmin.saveAdmin(Admin), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<admin> updateAdmin(@PathVariable Long id, @RequestBody admin newAdmin) {
        return ResponseEntity.ok(serviceAdmin.updateAdmin(id, newAdmin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        serviceAdmin.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticateAdmin(@RequestBody admin adminDetails) {
        boolean isAuthenticated = serviceAdmin.authenticate(adminDetails.getEmail(), adminDetails.getPassword());
        return isAuthenticated ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAdmins() {
        return ResponseEntity.ok(serviceAdmin.countAdmin());
    }
}

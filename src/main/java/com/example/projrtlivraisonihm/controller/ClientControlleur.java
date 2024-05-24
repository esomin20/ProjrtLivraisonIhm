package com.example.projrtlivraisonihm.controller;

import com.example.projrtlivraisonihm.Entities.client;
import com.example.projrtlivraisonihm.Services.client.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientControlleur {

    private final ServiceClient clientService;

    @Autowired
    public ClientControlleur(ServiceClient clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<client> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<client> getClientById(@PathVariable Long id) {
        return clientService.findClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<client> createClient(@RequestBody client newClient) {
        client savedClient = clientService.saveClient(newClient);
        return ResponseEntity.ok(savedClient);
    }

    @PutMapping("/{id}")
    public client updateClient(@PathVariable Long id, @RequestBody client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

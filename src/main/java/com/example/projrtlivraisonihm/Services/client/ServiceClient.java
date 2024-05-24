package com.example.projrtlivraisonihm.Services.client;

import com.example.projrtlivraisonihm.Entities.client;
import com.example.projrtlivraisonihm.Repesitory.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceClient {

    private final ClientRespository clientRepository;

    @Autowired
    public ServiceClient(ClientRespository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<client> findAllClients() {
        return clientRepository.findAll();
    }

    public Optional<client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<client> findClientsByName(String nom) {
        return clientRepository.findByNom(nom);
    }

    public List<client> findClientsByEmailContaining(String texte) {
        return clientRepository.findByEmailContaining(texte);
    }

    public List<client> findClientsByFirstName(String prenom) {
        return clientRepository.findByPrenom(prenom);
    }

    public List<client> findClientsBornAfter(Date date) {
        return clientRepository.findByDateNaissanceAfter(date);
    }

    public List<client> findClientsByNameAndFirstName(String nom, String prenom) {
        return clientRepository.findByNomAndPrenom(nom, prenom);
    }

    public client saveClient(client nouveauClient) {
        return clientRepository.save(nouveauClient);
    }

    public client updateClient(Long idClient, client clientMisAJour) {
        Optional<client> clientExistant = clientRepository.findById(idClient);
        if (clientExistant.isPresent()) {
            clientMisAJour.setIdClient(idClient);
            return clientRepository.save(clientMisAJour);
        } else {
            throw new IllegalArgumentException("Client non trouvé avec ID: " + idClient);
        }
    }

    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    public long countClients() {
        return clientRepository.count();
    }
}

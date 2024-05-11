package com.example.projrtlivraisonihm.Services.commande;

import com.example.projrtlivraisonihm.Entities.*;
import com.example.projrtlivraisonihm.Repesitory.ClientRespository;
import com.example.projrtlivraisonihm.Repesitory.CommandeRepository;
import com.example.projrtlivraisonihm.Repesitory.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCommande {
    private final CommandeRepository commandeRepository;
    private final ClientRespository clientRespository;
    private final LivreurRepository livreurRepository;

    @Autowired
    public ServiceCommande(CommandeRepository commandeRepository ,ClientRespository clientRespository, LivreurRepository livreurRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRespository = clientRespository;
        this.livreurRepository=livreurRepository;
    }
    public commande saveCommande(commande commande) {
        return commandeRepository.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    public commande updateCommande(Long id, commande newCommande) {
        return commandeRepository.findById(id)
                .map(existingCommande -> {
                    existingCommande.setNom(newCommande.getNom());
                    existingCommande.setDate_min(newCommande.getDate_min());
                    existingCommande.setDate_max(newCommande.getDate_max());
                    existingCommande.setAffecté(newCommande.isAffecté());
                    existingCommande.setType(newCommande.getType());
                    existingCommande.setAccomplie(newCommande.isAccomplie());

                    // Mise à jour des associations
                    if (newCommande.getAdmin() != null) {
                        existingCommande.setAdmin(newCommande.getAdmin());
                    }
                    if (newCommande.getLivreur() != null) {
                        existingCommande.setLivreur(newCommande.getLivreur());
                    }
                    if (newCommande.getAgence() != null) {
                        existingCommande.setAgence(newCommande.getAgence());
                    }
                    if (newCommande.getClient() != null) {
                        existingCommande.setClient(newCommande.getClient());
                    }

                    return commandeRepository.save(existingCommande);
                })
                .orElseThrow(() -> new IllegalArgumentException("Commande non trouvée avec l'ID: " + id));
    }

    // Méthode pour trouver une commande par son ID
    public commande trouverCommandeParId(int id) {
        return commandeRepository.findById(id);
    }

    // Méthode pour trouver toutes les commandes ayant un nom spécifique
    public List<commande> trouverCommandesParNom(String nom) {
        return commandeRepository.findByNom(nom);
    }

    // Méthode pour trouver toutes les commandes dont la date minimum est après une certaine date
    public List<commande> trouverCommandesParDateMinApres(Date date) {
        return commandeRepository.findByDateMinAfter(date);
    }

    // Méthode pour trouver toutes les commandes affectées ou non
    public List<commande> trouverCommandesParAffecte(boolean affecte) {
        return commandeRepository.findByAffecte(affecte);
    }

    // Méthode pour trouver toutes les commandes accomplies ou non
    public List<commande> trouverCommandesParAccomplie(boolean accomplie) {
        return commandeRepository.findByAccomplie(accomplie);
    }

    // Méthode pour trouver toutes les commandes d'un type spécifique
    public List<commande> trouverCommandesParType(TypeCommande type) {
        return commandeRepository.findByType(type);
    }

    // Méthode pour trouver toutes les commandes associées à un client spécifique
    public List<commande> trouverCommandesParClientId(Long idClient) {
        return commandeRepository.findByClient_IdClient(idClient);
    }

    @Transactional
    public commande affecterCommandeAClient(Long idCommande, Long idClient) {
        Optional<commande> commandeOpt = commandeRepository.findById(idCommande);
        Optional<client> clientOpt = clientRespository.findById(idClient);

        if (commandeOpt.isPresent() && clientOpt.isPresent()) {
            commande cmd = commandeOpt.get();
            client clt = clientOpt.get();

            cmd.setClient(clt);  // Assurez-vous que votre entité commande a un setter pour client
            return commandeRepository.save(cmd);
        } else {
            throw new RuntimeException("Commande ou Client introuvable");
        }
    }

    @Transactional
    public commande affecterCommandeALivreur(Long idCommande, Long idLivreur) {
        Optional<commande> commandeOpt = commandeRepository.findById(idCommande);
        Optional<livreur> livreurOpt = livreurRepository.findById(idLivreur);

        if (commandeOpt.isPresent() && livreurOpt.isPresent()) {
            commande cmd = commandeOpt.get();
            livreur lvr = livreurOpt.get();

            cmd.setLivreur(lvr);  // Assurez-vous que votre entité commande a un setter pour livreur
            return commandeRepository.save(cmd);
        } else {
            throw new RuntimeException("Commande ou Livreur introuvable");
        }
    }

    public long countCommande(){
        return commandeRepository.count();
    }


}

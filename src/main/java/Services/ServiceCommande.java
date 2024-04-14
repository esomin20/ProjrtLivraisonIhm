package Services;

import Repesitory.CommandeRepository;
import com.example.projrtlivraisonihm.Entities.TypeCommande;
import com.example.projrtlivraisonihm.Entities.commande;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ServiceCommande {
    private final CommandeRepository commandeRepository;

    @Autowired
    public ServiceCommande(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
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

    // Méthode pour assigner une commande à un livreur spécifique
    public void assignerCommandeALivreur(commande commande, livreur livr) {
        commandeRepository.assignerCommandeALivreur(commande, livr);
    }
}

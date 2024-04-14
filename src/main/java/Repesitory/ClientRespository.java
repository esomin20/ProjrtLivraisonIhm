package Repesitory;
import com.example.projrtlivraisonihm.Entities.client;
import com.example.projrtlivraisonihm.Entities.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRespository extends JpaRepository<client, Long>{
    // Trouver un client par son ID
    client findById(long id);

    // Trouver tous les clients ayant un nom spécifique
    List<client> findByNom(String nom);

    // Trouver tous les clients dont l'email contient un certain texte
    List<client> findByEmailContaining(String texte);

    // Exemples de méthodes personnalisées que vous pouvez ajouter :

    // Trouver tous les clients ayant un prénom spécifique
    List<client> findByPrenom(String prenom);

    // Trouver tous les clients nés après une certaine date
    List<client> findByDateNaissanceAfter(Date date);

    // Trouver tous les clients ayant un certain nom et un certain prénom
    List<client> findByNomAndPrenom(String nom, String prenom);

    // Méthode pour trouver tous les clients desservis par un livreur spécifique
    public List<client> getClientsDesservisParLivreur(livreur livr);
}

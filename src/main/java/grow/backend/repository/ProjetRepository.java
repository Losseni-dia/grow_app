package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Projet;

import java.util.List;


@Repository
public interface ProjetRepository extends CrudRepository<Projet, Long> {

    // Recherche par id
    Projet findById(int id);

    // Recherche par description (libellé) partielle (contient)
    List<Projet> findByLibelleContainingIgnoreCase(String description);

    // Recherche par secteur exact
    List<Projet> findBySecteurIgnoreCase(String secteur);

    // Recherche par pays (nom) via site -> ville -> pays
    List<Projet> findBySiteProjetLocalitePaysNom(String nom);

    // Recherche par ville (nom) via site -> ville
    List<Projet> findBySiteProjetLocaliteNomIgnoreCase(String ville);
    
    List<Projet> findByPorteurProjetId(Long porteurProjetId);
}

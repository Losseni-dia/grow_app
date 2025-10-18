package grow.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import grow.backend.model.Projet;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProjetRepository extends CrudRepository<Projet, Long> {

    // Recherche par id
    Optional<Projet> findById(Long id);

    // Recherche par description (libellé) partielle (contient)
    List<Projet> findByLibelleContainingIgnoreCase(String description);

    // Recherche par secteur exact
    List<Projet> findBySecteurIgnoreCase(String secteur);

    // Recherche par pays (nom) via site -> ville -> pays
    List<Projet> findBySiteProjetLocalitePaysNom(String nom);

    // Recherche par ville (nom) via site -> ville
    List<Projet> findBySiteProjetLocaliteNomIgnoreCase(String localite);
    
    List<Projet> findByPorteurProjetId(Long porteurProjetId);
}

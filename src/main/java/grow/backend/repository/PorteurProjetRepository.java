package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import grow.backend.model.PorteurProjet;
import grow.backend.model.Projet;

@Repository
public interface PorteurProjetRepository extends CrudRepository<PorteurProjet, Long> {
    // Ici tu peux ajouter des méthodes spécifiques à PorteurProjet
    Optional<PorteurProjet> findById(Long id);
     
    @Query("SELECT p.projets FROM PorteurProjet p WHERE p.id = :porteurId")
    List<Projet> findProjetsByPorteurId(@Param("porteurId") Long id);
}

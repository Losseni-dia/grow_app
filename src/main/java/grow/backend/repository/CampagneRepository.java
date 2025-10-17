package grow.backend.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Campagne;

public interface CampagneRepository extends CrudRepository<Campagne, Long> {
   Optional<Campagne> findByProjetId(Long projetId);
     // Recherche de campagnes actives plus spécifiques selon dates (exemple)
    List<Campagne> findByDateDebutBeforeAndDateFinAfter(LocalDateTime start, LocalDateTime end);

    // Recherche par objectif de financement supérieur à une valeur donnée
    List<Campagne> findByObjectifFinancementGreaterThan(double montant);
}

package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.SiteProjet;

import java.util.Optional;

@Repository
public interface SiteProjetRepository extends CrudRepository<SiteProjet, Long> {
    Optional<SiteProjet> findByLocaliteId(String LocaliteId);

    Optional<SiteProjet> findById(String id);
}

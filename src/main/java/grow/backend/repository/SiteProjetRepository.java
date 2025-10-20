package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.SiteProjet;

import java.util.Optional;

@Repository
public interface SiteProjetRepository extends CrudRepository<SiteProjet, Long> {
    Optional<SiteProjet> findByLocaliteId(Long LocaliteId);

    Optional<SiteProjet> findById(Long id);
}

package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.SiteProjet;

import java.util.List;

@Repository
public interface SiteProjetRepository extends CrudRepository<SiteProjet, Long> {
    List<SiteProjet> findByLocaliteId(Long LocaliteId);
}

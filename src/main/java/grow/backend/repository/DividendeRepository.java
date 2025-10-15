package grow.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Dividende;
import grow.backend.model.StatutDividende;

public interface DividendeRepository extends CrudRepository<Dividende, Long> {
    List<Dividende> findByPartId(Long partId);

    List<Dividende> findByStatutDividende(StatutDividende statutDividende);
}

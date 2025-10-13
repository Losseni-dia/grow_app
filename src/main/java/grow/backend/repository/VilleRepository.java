package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Ville;

import java.util.List;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Long> {
    List<Ville> findByPaysId(Long paysId);
}

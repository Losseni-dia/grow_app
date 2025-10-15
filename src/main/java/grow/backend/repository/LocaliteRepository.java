package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Localite;

import java.util.List;

@Repository
public interface LocaliteRepository extends CrudRepository<Localite, Long> {
    List<Localite> findByPaysId(Long paysId);
}

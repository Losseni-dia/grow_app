package grow.backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Pays;


@Repository
public interface PaysRepository extends CrudRepository<Pays, Long> {
    Optional<Pays> findById(String id);
    Optional<Pays> findByNom(String nom);
}

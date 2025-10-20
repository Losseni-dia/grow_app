package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Localite;

import java.util.Optional;



@Repository
public interface LocaliteRepository extends CrudRepository<Localite, Long> {
    Optional<Localite> findByPaysNom(String nom);

    Optional<Localite> findById(Long id);
    
    Localite findByCodePostal(String codePostal);

    Localite findByNom(String localiteNom);

}

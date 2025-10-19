package grow.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grow.backend.model.Localite;

import java.util.Optional;



@Repository
public interface LocaliteRepository extends CrudRepository<Localite, Long> {
    Optional<Localite> findByPays(String pays);

    Localite findById(String id);
    
    Localite findByPostalCode(String postalCode);

    Localite findByLocality(String localite);

}

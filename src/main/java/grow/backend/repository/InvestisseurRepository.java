package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Investisseur;

public interface InvestisseurRepository extends CrudRepository<Investisseur, Long> {
    List<Investisseur> findByDiasporaTrue();
    
    List<Investisseur> findByNom(String nom);

    Optional<Investisseur> findById(Long id);
}

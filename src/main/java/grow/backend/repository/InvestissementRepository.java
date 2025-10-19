package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Investissement;

public interface InvestissementRepository extends CrudRepository<Investissement, Long> {
    List<Investissement> findByCampagneId(String campagneId);

    List<Investissement> findByInvestisseurId(String investisseurId);

    Optional<Investissement> findById(String id);
}

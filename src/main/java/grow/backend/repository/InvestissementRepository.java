package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Investissement;

public interface InvestissementRepository extends CrudRepository<Investissement, Long> {
    List<Investissement> findByCampagneId(Long campagneId);

    List<Investissement> findByInvestisseurId(Long investisseurId);

    Optional<Investissement> findById(Long id);
}

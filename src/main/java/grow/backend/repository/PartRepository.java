package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Part;
import grow.backend.model.StatutPart;

public interface PartRepository extends CrudRepository<Part, Long> {
    Optional<Part> findByInvestissementId(Long investissementId);

    List<Part> findByStatutPart(StatutPart statutPart);
}
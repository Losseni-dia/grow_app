package grow.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Investisseur;

public interface InvestisseurRepository extends CrudRepository<Investisseur, Long> {
    List<Investisseur> findByDiasporaTrue();
    
    List<Investisseur> findByNom(String nom);


    Investisseur findById(String id);
}

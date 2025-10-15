package grow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.*;
import grow.backend.model.Investisseur;
import grow.backend.repository.InvestisseurRepository;

@Service
public class InvestisseurService {

    @Autowired
    private InvestisseurRepository investisseurRepository;

    public void add(Investisseur investisseur) {
        investisseurRepository.save(investisseur);
    }

    public List<Investisseur> getInvestisseursDiaspora() {
        List<Investisseur> investisseurs = investisseurRepository.findByDiasporaTrue();
        if (investisseurs.isEmpty()) {
            throw new InvestisseurNotFoundException(-1L);
        }
        return investisseurs;
    }

    public List<Investisseur> getAll() {
        List<Investisseur> investisseurs = (List<Investisseur>) investisseurRepository.findAll();
        if (investisseurs.isEmpty()) {
            throw new InvestisseurNotFoundException(-1L);
        }
        return investisseurs;
    }

    public void UpdatePortefeuilleTotal(Long id, double nouveauMontant) {
        Investisseur inv = investisseurRepository.findById(id)
                .orElseThrow(() -> new InvestisseurNotFoundException(id));
        inv.setPortefeuilleTotal(nouveauMontant);
        investisseurRepository.save(inv);
    }

    public void delete(Long investisseurId) {
        if (investisseurRepository.existsById(investisseurId)) {
            investisseurRepository.deleteById(investisseurId);
        } else {
            throw new InvestisseurNotFoundException(investisseurId);
        }
    }
}

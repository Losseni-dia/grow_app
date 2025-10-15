package grow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.*;
import grow.backend.model.Investissement;
import grow.backend.model.Part;
import grow.backend.repository.InvestissementRepository;

@Service
public class InvestissementService {

    @Autowired
    private InvestissementRepository investissementRepository;

    public void add(Investissement investissement) {
        investissementRepository.save(investissement);
    }

    public List<Investissement> getAllByCampagne(Long campagneId) {
        List<Investissement> investissements = investissementRepository.findByCampagneId(campagneId);
        if (investissements.isEmpty()) {
            throw new InvestissementNotFoundException(campagneId);
        }
        return investissements;
    }

    public List<Investissement> getByInvestisseur(Long investisseurId) {
        List<Investissement> investissements = investissementRepository.findByInvestisseurId(investisseurId);
        if (investissements.isEmpty()) {
            throw new InvestisseurNotFoundException(investisseurId);
        }
        return investissements;
    }

    public void UpdatePart(Long investissementId, int nombreParts) {
        Investissement investissement = investissementRepository.findById(investissementId)
                .orElseThrow(() -> new InvestissementNotFoundException(investissementId));
        Part part = investissement.getPart();

        if (part == null) {
            part = new Part();
            part.setNombreParts(nombreParts);
            part.setInvestissement(investissement);
            investissement.setPart(part);
        } else {
            part.setNombreParts(nombreParts);
        }

        investissementRepository.save(investissement);
    }

    public void delete(Long investissementId) {
        if (investissementRepository.existsById(investissementId)) {
            investissementRepository.deleteById(investissementId);
        } else {
            throw new InvestissementNotFoundException(investissementId);
        }
    }
}

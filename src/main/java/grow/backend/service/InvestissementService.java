package grow.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.*;
import grow.backend.model.Investissement;
import grow.backend.model.Localite;
import grow.backend.model.Part;
import grow.backend.repository.InvestissementRepository;

@Service
public class InvestissementService {

    @Autowired
    private InvestissementRepository investissementRepository;

    public void add(Investissement investissement) {
        investissementRepository.save(investissement);
    }

    public Investissement get(String id) {
        return investissementRepository.findById(id)
                .orElseThrow(() -> new InvestissementNotFoundException(id));
    }

    public List<Investissement> getAll() {
         List<Investissement> result = new ArrayList<>();
         investissementRepository.findAll().forEach(result::add);
         if (result.isEmpty()) {
             throw new InvestissementNotFoundException(null);
         }
        return result;
    }

    public Investissement updateInvestissement(String id, Investissement updatedInvestissement) {
        // On cherche l'investissement à mettre à jour
        Investissement existingInvestissement = investissementRepository.findById(id)
                .orElseThrow(() -> new InvestissementNotFoundException(id));

        // Mise à jour des champs modifiables
        existingInvestissement.setMontant(updatedInvestissement.getMontant());
        existingInvestissement.setDate(LocalDateTime.now()); // On met à jour la date si nécessaire
        existingInvestissement.setMoyenPaiement(updatedInvestissement.getMoyenPaiement());
        existingInvestissement.setFrais(updatedInvestissement.getFrais());

        // Associations facultatives
        if (updatedInvestissement.getCampagne() != null) {
            existingInvestissement.setCampagne(updatedInvestissement.getCampagne());
        }
         if (updatedInvestissement.getInvestisseur() != null) {
            existingInvestissement.setInvestisseur(updatedInvestissement.getInvestisseur());
        }
        if (updatedInvestissement.getPart() != null) {
            existingInvestissement.setPart(updatedInvestissement.getPart());
        }

        // Enregistrement de la mise à jour
        return investissementRepository.save(existingInvestissement);
    }
    
    public List<Investissement> getAllByCampagne(String campagneId) {
        List<Investissement> investissements = investissementRepository.findByCampagneId(campagneId);
        if (investissements.isEmpty()) {
            throw new InvestissementNotFoundException(campagneId);
        }
        return investissements;
    }

    public List<Investissement> getByInvestisseur(String investisseurId) {
        List<Investissement> investissements = investissementRepository.findByInvestisseurId(investisseurId);
        if (investissements.isEmpty()) {
            throw new InvestisseurNotFoundException(investisseurId);
        }
        return investissements;
    }

    public void UpdatePart(String investissementId, int nombreParts) {
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

    public void delete(String investissementId) {
        Long indice = (long) Integer.parseInt(investissementId);
        if (investissementRepository.existsById(indice)) {
            investissementRepository.deleteById(indice);
        } else {
            throw new InvestissementNotFoundException(investissementId);
        }
    }
}

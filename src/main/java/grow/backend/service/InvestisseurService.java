package grow.backend.service;

import java.util.List;
import java.util.Objects;

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

    public Investisseur get(String id) {
        Long indice = Long.parseLong(id);
        return investisseurRepository.findById(indice)
                .orElseThrow(() -> new InvestisseurNotFoundException(id));
    }
    
    public List<Investisseur> getAll() {
        List<Investisseur> investisseurs = (List<Investisseur>) investisseurRepository.findAll();
        if (investisseurs.isEmpty()) {
            throw new InvestisseurNotFoundException(null);
        }
        return investisseurs;
    }

    public Investisseur updateInvestisseur(String id, Investisseur updatedInvestisseur) {
        // Vérifie que l’investisseur existe
        Long indice = Long.parseLong(id);
        Investisseur existingInvestisseur = investisseurRepository.findById(indice)
                .orElseThrow(() -> new InvestisseurNotFoundException(id));

        // Mise à jour des champs simples
        if (Objects.nonNull(updatedInvestisseur.getPortefeuilleTotal())) {
            existingInvestisseur.setPortefeuilleTotal(updatedInvestisseur.getPortefeuilleTotal());
        }

        // Mise à jour du statut diaspora
        existingInvestisseur.setDiaspora(updatedInvestisseur.isDiaspora());
        // Gestion des investissements associés
        if (updatedInvestisseur.getInvestissements() != null &&
                !updatedInvestisseur.getInvestissements().isEmpty()) {
            existingInvestisseur.getInvestissements().clear();
            existingInvestisseur.getInvestissements()
                    .addAll(updatedInvestisseur.getInvestissements());
            updatedInvestisseur.getInvestissements()
                    .forEach(i -> i.setInvestisseur(existingInvestisseur));
        }

        // Sauvegarde et retour de l'entité mise à jour
        return investisseurRepository.save(existingInvestisseur);
    }

    public void delete(String investisseurId) {
        Long indice = (long) Integer.parseInt(investisseurId);
        if (investisseurRepository.existsById(indice)) {
            investisseurRepository.deleteById(indice);
        } else {
            throw new InvestisseurNotFoundException(investisseurId);
        }
    }

    public List<Investisseur> getInvestisseursDiaspora() {
        List<Investisseur> investisseurs = investisseurRepository.findByDiasporaTrue();
        if (investisseurs.isEmpty()) {
            throw new InvestisseurNotFoundException(null);
        }
        return investisseurs;
    }

    

    public void UpdatePortefeuilleTotal(String id, double nouveauMontant) {
        Long indice = Long.parseLong(id);
        Investisseur inv = investisseurRepository.findById(indice)
                .orElseThrow(() -> new InvestisseurNotFoundException(id));
        inv.setPortefeuilleTotal(nouveauMontant);
        investisseurRepository.save(inv);
    }

   
}

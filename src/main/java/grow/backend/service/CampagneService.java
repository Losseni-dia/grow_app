package grow.backend.service;

import grow.backend.exception.handler.CampagneNotFoundException;
import grow.backend.model.Campagne;
import grow.backend.model.Investissement;
import grow.backend.repository.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampagneService {

    @Autowired
    private CampagneRepository campagneRepository;

    // Create (Add)
    public Campagne add(Campagne campagne) {
        return campagneRepository.save(campagne);
    }

    // Read (Get by Id)
    public Campagne getById(Long id) {
        return campagneRepository.findById(id)
                .orElseThrow(() -> new CampagneNotFoundException(id));
    }

    // Read (Get by Projet Id)
    public Optional<Campagne> getByProjetId(Long projetId) {
        Optional<Campagne> campagnes = campagneRepository.findByProjetId(projetId);
        if (campagnes.isEmpty()) {
            throw new CampagneNotFoundException(-1L); // Pas de campagne pour ce projet
        }
        return campagnes;
    }

    // Update
    public Campagne update(Campagne campagne) {
        if (!campagneRepository.existsById(campagne.getId())) {
            throw new CampagneNotFoundException(campagne.getId());
        }
        // Optionnel : vérifier cohérence des dates (ex début < fin)
        if (campagne.getDateDebut() != null && campagne.getDateFin() != null &&
                campagne.getDateFin().isBefore(campagne.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin doit être après la date de début");
        }
        return campagneRepository.save(campagne);
    }

    // Delete
    public void delete(Long id) {
        if (!campagneRepository.existsById(id)) {
            throw new CampagneNotFoundException(id);
        }
        campagneRepository.deleteById(id);
    }

    // Méthodes intelligentes additionnelles :

    // Trouver les campagnes actives à une date donnée
   public List<Campagne> findActiveCampagnes(LocalDateTime date) {
        Iterable<Campagne> iterable = campagneRepository.findAll();
        List<Campagne> list = new ArrayList<>();
        iterable.forEach(list::add);

        return list.stream()
                .filter(campagne -> !campagne.getDateDebut().isAfter(date) && !campagne.getDateFin().isBefore(date))
                .toList();
    }    

    // Calculer la part disponible après les investissements
   public int calculerPartsDisponibles(Long campagneId) {
    Campagne campagne = getById(campagneId);
    int totalPartsInvesties = campagne.getInvestissements().stream()
        .mapToInt(i -> i.getPart().getNombreParts())
        .sum();
    return campagne.getPartsDisponible() - totalPartsInvesties;
}


    // Vérifier si un pourcentage de parts est disponible pour nouvelle souscription
    public boolean verifierDisponibiliteParts(Long campagneId, double pourcentSouhaite) {
        Campagne campagne = getById(campagneId);
        double pourcentDisponible = campagne.getPourcentParts() -
                campagne.getInvestissements().stream()
                        .mapToDouble(i -> (i.getPart().getNombreParts() * 100.0) / campagne.getPartsDisponible())
                        .sum();
        return pourcentSouhaite <= pourcentDisponible;
    }

    // Ajouter un investissement à une campagne (gestion des liaisons)
    public void ajouterInvestissement(Long campagneId, Investissement investissement) {
        Campagne campagne = getById(campagneId);
        investissement.setCampagne(campagne);
        campagne.getInvestissements().add(investissement);
        campagneRepository.save(campagne);
    }
}

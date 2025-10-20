package grow.backend.service;

import grow.backend.exception.handler.CampagneNotFoundException;
import grow.backend.exception.handler.DividendeNotFoundException;
import grow.backend.exception.handler.UserNotFoundException;
import grow.backend.model.Campagne;
import grow.backend.model.Dividende;
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
    public Campagne get(String id) {
          Long indice = (long) Integer.parseInt(id);
        return campagneRepository.findById(indice)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

      public List<Campagne> getAll() {
         List<Campagne> result = new ArrayList<>();
         campagneRepository.findAll().forEach(result::add);
        
         if (result.isEmpty()) {
             throw new CampagneNotFoundException(null);
         }
         
        return result;
    }

    // Read (Get by Projet Id)
    public Optional<Campagne> getByProjetNom(String projetLibelle) {
        Optional<Campagne> campagnes = campagneRepository.findByProjetLibelle(projetLibelle);
        if (campagnes.isEmpty()) {
            throw new CampagneNotFoundException(projetLibelle); // Pas de campagne pour ce projet
        }
        return campagnes;
    }

    // Update
    public Campagne update(String id, Campagne campagne) {
        if (!campagneRepository.existsById(campagne.getId())) {
            throw new CampagneNotFoundException(id);
        }
        // Optionnel : vérifier cohérence des dates (ex début < fin)
        if (campagne.getDateDebut() != null && campagne.getDateFin() != null &&
                campagne.getDateFin().isBefore(campagne.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin doit être après la date de début");
        }
        return campagneRepository.save(campagne);
    }

    // Delete
    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        if (!campagneRepository.existsById(indice)) {
            throw new CampagneNotFoundException(id);
        }
        campagneRepository.deleteById(indice);
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
   public int calculerPartsDisponibles(String campagneId) {
    Campagne campagne = get(campagneId);
    int totalPartsInvesties = campagne.getInvestissements().stream()
        .mapToInt(i -> i.getPart().getNombreParts())
        .sum();
    return campagne.getPartsDisponible() - totalPartsInvesties;
}


    // Vérifier si un pourcentage de parts est disponible pour nouvelle souscription
    public boolean verifierDisponibiliteParts(String campagneId, double pourcentSouhaite) {
        Campagne campagne = get(campagneId);
        double pourcentDisponible = campagne.getPourcentParts() -
                campagne.getInvestissements().stream()
                        .mapToDouble(i -> (i.getPart().getNombreParts() * 100.0) / campagne.getPartsDisponible())
                        .sum();
        return pourcentSouhaite <= pourcentDisponible;
    }

    // Ajouter un investissement à une campagne (gestion des liaisons)
    public void ajouterInvestissement(String campagneId, Investissement investissement) {
        Campagne campagne = get(campagneId);
        investissement.setCampagne(campagne);
        campagne.getInvestissements().add(investissement);
        campagneRepository.save(campagne);
    }
}

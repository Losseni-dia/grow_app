package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import grow.backend.model.Projet;
import grow.backend.repository.ProjetRepository;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> findAll() {
        List<Projet> result = new ArrayList<>();
        projetRepository.findAll().forEach(result::add);
        return result;
    }

    public void findById(Long id) {
        projetRepository.findById(id);
    }

    public List<Projet> findByPorteurProjetId(Long porteurId) {
        return projetRepository.findByPorteurProjetId(porteurId);
    }

    public List<Projet> findByLibelleContainingIgnoreCase(String libelle) {
        return projetRepository.findByLibelleContainingIgnoreCase(libelle);
    }

    public List<Projet> findBySecteurIgnoreCase(String secteur) {
        return projetRepository.findBySecteurIgnoreCase(secteur);
    }

    public List<Projet> findBySiteVillePaysNomIgnoreCase(String nomPays) {
        return projetRepository.findBySiteVillePaysNomIgnoreCase(nomPays);
    }

    public List<Projet> findBySiteVilleNomIgnoreCase(String nomVille) {
        return projetRepository.findBySiteVilleNomIgnoreCase(nomVille);
    }

    public void add(Projet projet) {
         projetRepository.save(projet);
    }

    public void updateProjet(Projet projet) {
        projetRepository.save(projet);
    }

    public void deleteById(Long id) {
        projetRepository.deleteById(id);
    }
}

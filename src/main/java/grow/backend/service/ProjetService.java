package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.ProjetNotFoundException;
import grow.backend.model.Projet;
import grow.backend.repository.ProjetRepository;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> getAll() {
        List<Projet> result = new ArrayList<>();
        projetRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new ProjetNotFoundException(-1L);
        }
        return result;
    }

    public Projet get(long id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new ProjetNotFoundException(id));
    }

    public List<Projet> findByPorteurProjetId(Long porteurId) {
        List<Projet> projets = projetRepository.findByPorteurProjetId(porteurId);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(porteurId);
        }
        return projets;
    }

    public List<Projet> findByLibelleContainingIgnoreCase(String libelle) {
        List<Projet> projets = projetRepository.findByLibelleContainingIgnoreCase(libelle);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(-1L);
        }
        return projets;
    }

    public List<Projet> findBySecteurIgnoreCase(String secteur) {
        List<Projet> projets = projetRepository.findBySecteurIgnoreCase(secteur);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(-1L);
        }
        return projets;
    }

    public List<Projet> findBySiteProjetLocalitePaysNomIgnoreCase(String nomPays) {
        List<Projet> projets = projetRepository.findBySiteProjetLocalitePaysNom(nomPays);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(-1L);
        }
        return projets;
    }

    public List<Projet> findBySiteProjetLocaliteNomIgnoreCase(String nomLocalite) {
        List<Projet> projets = projetRepository.findBySiteProjetLocaliteNomIgnoreCase(nomLocalite);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(-1L);
        }
        return projets;
    }

    public void add(Projet projet) {
        projetRepository.save(projet);
    }
    
    public void update(Long id, Projet projet) {
        projetRepository.save(projet);
    }

    public void deleteById(Long id) {
        if (projetRepository.existsById(id)) {
            projetRepository.deleteById(id);
        } else {
            throw new ProjetNotFoundException(id);
        }
    }
}

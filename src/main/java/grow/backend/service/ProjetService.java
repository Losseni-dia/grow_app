package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.ProjetNotFoundException;
import grow.backend.model.Campagne;
import grow.backend.model.PorteurProjet;
import grow.backend.model.Projet;
import grow.backend.model.SiteProjet;
import grow.backend.repository.CampagneRepository;
import grow.backend.repository.PorteurProjetRepository;
import grow.backend.repository.ProjetRepository;
import grow.backend.repository.SiteProjetRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private PorteurProjetRepository porteurProjetRepository;

    @Autowired
    private CampagneRepository campagneRepository;

    @Autowired
    private SiteProjetRepository siteProjetRepository;

    public List<Projet> getAll() {
        List<Projet> result = new ArrayList<>();
        projetRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return result;
    }

    public Projet get(String id) {
        Long indice = (long) Integer.parseInt(id);
        return projetRepository.findById(indice)
                .orElseThrow(() -> new ProjetNotFoundException(id));
    }

    public List<Projet> findByPorteurProjetId(String porteurId) {
        Long indice = (long) Integer.parseInt(porteurId);
        List<Projet> projets = projetRepository.findByPorteurProjetId(indice);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(porteurId);
        }
        return projets;
    }

    public List<Projet> findByLibelleContainingIgnoreCase(String libelle) {
        List<Projet> projets = projetRepository.findByLibelleContainingIgnoreCase(libelle);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return projets;
    }

    public List<Projet> findBySecteurIgnoreCase(String secteur) {
        List<Projet> projets = projetRepository.findBySecteurIgnoreCase(secteur);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return projets;
    }

    public List<Projet> findBySiteProjetLocalitePaysNomIgnoreCase(String nomPays) {
        List<Projet> projets = projetRepository.findBySiteProjetLocalitePaysNom(nomPays);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return projets;
    }

    public List<Projet> findBySiteProjetLocaliteNomIgnoreCase(String nomLocalite) {
        List<Projet> projets = projetRepository.findBySiteProjetLocaliteNomIgnoreCase(nomLocalite);
        if (projets.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return projets;
    }

    public void add(Projet projet) {
        projetRepository.save(projet);
    }
        
    @Transactional
    public void update(String id, Projet projetModifie) {
        Long indice = (long) Integer.parseInt(id);
        Projet projetExistant = projetRepository.findById(indice)
                .orElseThrow(() -> new ProjetNotFoundException("Projet non trouvé avec id " + id));
    
        projetExistant.setLibelle(projetModifie.getLibelle());
        projetExistant.setSecteur(projetModifie.getSecteur());
        projetExistant.setValuation(projetModifie.getValuation());
        projetExistant.setRoiProjete(projetModifie.getRoiProjete());
        projetExistant.setStatutProjet(projetModifie.getStatutProjet());
        projetExistant.setPorteurProjet(projetModifie.getPorteurProjet());
        projetExistant.setSiteProjet(projetModifie.getSiteProjet());

        projetRepository.save(projetExistant);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        if (projetRepository.existsById(indice)) {
            projetRepository.deleteById(indice);
        } else {
            throw new ProjetNotFoundException(id);
        }
    }

    public List<PorteurProjet> getAllPorteurProjets() {
        List<PorteurProjet> result = new ArrayList<>();
        porteurProjetRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return result;
    }

    public List<SiteProjet> getAllSiteProjets() {
        List<SiteProjet> result = new ArrayList<>();
        siteProjetRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return result;
    }

    public List<Campagne> getAllCampagnes() {
        List<Campagne> result = new ArrayList<>();
        campagneRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new ProjetNotFoundException(null);
        }
        return result;
    }

    
}

package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.model.SiteProjet;
import grow.backend.repository.SiteProjetRepository;

import java.util.List;
import java.util.ArrayList;


@Service
public class SiteService {

    @Autowired
    private SiteProjetRepository siteRepository;

    public List<SiteProjet> getAll() {
        List<SiteProjet> result = new ArrayList<>();
        siteRepository.findAll().forEach(result::add);
        return result;
    }

    public void get(Long id) {
        siteRepository.findById(id).orElse(null);
    }

    public List<SiteProjet> findByVilleId(Long villeId) {
        return siteRepository.findByVilleId(villeId);
    }

    public void add(SiteProjet site) {
        siteRepository.save(site);
    }

    public void updateSite(SiteProjet site) {
        siteRepository.save(site);
    }

    public void deleteById(Long id) {
        siteRepository.deleteById(id);
    }
}

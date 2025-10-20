package grow.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.SiteProjetNotFoundException;
import grow.backend.model.SiteProjet;
import grow.backend.repository.SiteProjetRepository;

@Service
public class SiteService {

    @Autowired
    private SiteProjetRepository siteRepository;

    public List<SiteProjet> getAll() {
        List<SiteProjet> result = new ArrayList<>();
        siteRepository.findAll().forEach(result::add);
        if (result.isEmpty()) {
            throw new SiteProjetNotFoundException(null);
        }
        return result;
    }

    public SiteProjet get(String id) {
        Long indice = Long.parseLong(id);
        return siteRepository.findById(indice)
                .orElseThrow(() -> new SiteProjetNotFoundException(id));
    }

    public Optional<SiteProjet> findByLocaliteId(String localiteId) {
        Long indice = (long) Integer.parseInt(localiteId);
        Optional<SiteProjet> sites = siteRepository.findByLocaliteId(indice);
        if (sites.isEmpty()) {
            throw new SiteProjetNotFoundException(localiteId);
        }
        return sites;
    }

    public void add(SiteProjet site) {
        siteRepository.save(site);
    }

    public void updateSite(SiteProjet site) {
        if (siteRepository.existsById(site.getId())) {
            siteRepository.save(site);
        } else {
            throw new SiteProjetNotFoundException(null);
        }
    }

    public void deleteById(String id) {
        Long indice = (long) Integer.parseInt(id);
        if (siteRepository.existsById(indice)) {
            siteRepository.deleteById(indice);
        } else {
            throw new SiteProjetNotFoundException(id);
        }
    }
}

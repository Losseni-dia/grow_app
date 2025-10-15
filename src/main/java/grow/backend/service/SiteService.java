package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

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
            throw new SiteProjetNotFoundException(-1L);
        }
        return result;
    }

    public SiteProjet get(Long id) {
        return siteRepository.findById(id)
                .orElseThrow(() -> new SiteProjetNotFoundException(id));
    }

    public List<SiteProjet> findByLocaliteId(Long localiteId) {
        List<SiteProjet> sites = siteRepository.findByLocaliteId(localiteId);
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
            throw new SiteProjetNotFoundException(site.getId());
        }
    }

    public void deleteById(Long id) {
        if (siteRepository.existsById(id)) {
            siteRepository.deleteById(id);
        } else {
            throw new SiteProjetNotFoundException(id);
        }
    }
}

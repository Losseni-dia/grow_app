package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import grow.backend.model.Localite;
import grow.backend.repository.LocaliteRepository;

@Service
public class LocaliteService {

    @Autowired
    private LocaliteRepository localiteRepository;

    public List<Localite> getAll() {
        List<Localite> result = new ArrayList<>();
        localiteRepository.findAll().forEach(result::add);
        return result;
    }

    public void get(Long id) {
        localiteRepository.findById(id);
    }

    public Optional<Localite> findByPaysId(Long paysId) {
        return localiteRepository.findByPaysId(paysId);
    }

    public void add(Localite ville) {
        localiteRepository.save(ville);
    }

    public void updateVille(Localite ville) {
         localiteRepository.save(ville);
    }

    public void deleteById(Long id) {
        localiteRepository.deleteById(id);
    }
}

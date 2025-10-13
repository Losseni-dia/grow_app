package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import grow.backend.model.Ville;
import grow.backend.repository.VilleRepository;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    public List<Ville> getAll() {
        List<Ville> result = new ArrayList<>();
        villeRepository.findAll().forEach(result::add);
        return result;
    }

    public void get(Long id) {
        villeRepository.findById(id);
    }

    public List<Ville> findByPaysId(Long paysId) {
        return villeRepository.findByPaysId(paysId);
    }

    public void add(Ville ville) {
        villeRepository.save(ville);
    }

    public void updateVille(Ville ville) {
         villeRepository.save(ville);
    }

    public void deleteById(Long id) {
        villeRepository.deleteById(id);
    }
}

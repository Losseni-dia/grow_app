package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import grow.backend.exception.handler.CampagneNotFoundException;
import grow.backend.exception.handler.InvestisseurNotFoundException;
import grow.backend.exception.handler.LocaliteNotFoundException;
import grow.backend.model.Localite;
import grow.backend.repository.LocaliteRepository;

@Service
public class LocaliteService {

    @Autowired
    private LocaliteRepository localiteRepository;

    public List<Localite> getAll() {
        List<Localite> result = new ArrayList<>();
        localiteRepository.findAll().forEach(result::add);
        
        if (result.isEmpty()) {
            throw new CampagneNotFoundException(null);
        }
         
        return result;
    }

    public Localite get(String id) {
        return localiteRepository.findById(id);
    }

    public Optional<Localite> findByPaysId(String pays) {
        return localiteRepository.findByPays(pays);
    }

    public void add(Localite ville) {
        localiteRepository.save(ville);
    }

    public void update(Localite ville) {
         localiteRepository.save(ville);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
         if (localiteRepository.existsById(indice)) {
             localiteRepository.deleteById(indice);
        } else {
            throw new LocaliteNotFoundException(id);
        }
        
        localiteRepository.deleteById(indice);
    }
}

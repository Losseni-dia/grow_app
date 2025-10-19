package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import grow.backend.exception.handler.CampagneNotFoundException;
import grow.backend.exception.handler.PaysNotFoundException;
import grow.backend.model.Pays;
import grow.backend.repository.PaysRepository;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    public List<Pays> getAll() {
        List<Pays> result = new ArrayList<>();
        paysRepository.findAll().forEach(result::add);

        
        if (result.isEmpty()) {
            throw new PaysNotFoundException(null);
        }
         
        return result;
    }

    public void get(String id) {
        paysRepository.findById(id).orElse(null);
    }

    public void add(Pays pays) {
        paysRepository.save(pays);
    }

    public void updatePays(String id, Pays pays) {
        paysRepository.save(pays);
    }

    public void deleteById(String id) {
        Long indice = (long) Integer.parseInt(id);
        paysRepository.deleteById(indice);
    }
}

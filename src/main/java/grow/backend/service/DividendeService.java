package grow.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grow.backend.exception.handler.DividendeNotFoundException;
import grow.backend.exception.handler.InvestisseurNotFoundException;
import grow.backend.exception.handler.UserNotFoundException;
import grow.backend.model.Dividende;
import grow.backend.model.Investissement;
import grow.backend.model.StatutDividende;
import grow.backend.repository.DividendeRepository;

@Service
public class DividendeService {
    @Autowired
    private DividendeRepository dividendeRepository;

    public void add(Dividende dividende) {
        dividendeRepository.save(dividende);
    }

    public Dividende get(String id) {
        Long indice = (long) Integer.parseInt(id);
        return dividendeRepository.findById(indice)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

     public List<Dividende> getAll() {
         List<Dividende> result = new ArrayList<>();
         dividendeRepository.findAll().forEach(result::add);

         if (result.isEmpty()) {
             throw new DividendeNotFoundException(null);
         }
        
        return result;
    }

    public void update(Dividende dividende) {
        if (dividendeRepository.existsById(dividende.getId())) {
            dividendeRepository.save(dividende);
        } else {
            throw new DividendeNotFoundException(null);
        }
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        if (dividendeRepository.existsById(indice)) {
            dividendeRepository.deleteById(indice);
        } else {
            throw new DividendeNotFoundException(id);
        }
    }

    public Optional<Dividende> getAllByPart(String partId) {
        Long indice = (long) Integer.parseInt(partId);
        Optional<Dividende> dividendes = dividendeRepository.findByPartId(indice);
        if (dividendes.isEmpty()) {
            throw new DividendeNotFoundException(partId); // ou exception spécifique si id est partId
        }
        return dividendes;
    }

    public List<Dividende> getAllByStatut(StatutDividende statut) {
        List<Dividende> dividendes = dividendeRepository.findByStatutDividende(statut);
        if (dividendes.isEmpty()) {
            throw new DividendeNotFoundException(null); // id fictif
        }
        return dividendes;
    }

    public double calculerMontantTotal(Dividende dividende) {
        int nombreParts = dividende.getPart().getNombreParts();
        return dividende.getMontantParPart() * nombreParts;
    }
}

package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.PorteurProjetNotFoundException;
import grow.backend.model.PorteurProjet;
import grow.backend.repository.PorteurProjetRepository;

@Service
public class PorteurProjetService {

    @Autowired
    private PorteurProjetRepository porteurProjetRepository;

    public List<PorteurProjet> getAll() {
        List<PorteurProjet> porteurProjets = new ArrayList<>();
        porteurProjetRepository.findAll().forEach(porteurProjets::add);
        if (porteurProjets.isEmpty()) {
            throw new PorteurProjetNotFoundException(-1L);
        }
        return porteurProjets;
    }

    public PorteurProjet get(Long id) {
        return porteurProjetRepository.findById(id)
                .orElseThrow(() -> new PorteurProjetNotFoundException(id));
    }

    public void add(PorteurProjet porteur) {
        porteurProjetRepository.save(porteur);
    }

    public void deleteById(Long id) {
        if (porteurProjetRepository.existsById(id)) {
            porteurProjetRepository.deleteById(id);
        } else {
            throw new PorteurProjetNotFoundException(id);
        }
    }

    public void updatePorteurProjet(Long id, PorteurProjet porteurProjet) {
        if (porteurProjetRepository.existsById(id)) {
            porteurProjetRepository.save(porteurProjet);
        } else {
            throw new PorteurProjetNotFoundException(id);
        }
    }
}

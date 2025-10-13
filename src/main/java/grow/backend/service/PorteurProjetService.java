package grow.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.model.PorteurProjet;
import grow.backend.repository.PorteurProjetRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PorteurProjetService {

    @Autowired
    private PorteurProjetRepository porteurProjetRepository;

   public List<PorteurProjet> getAll() {
        List<PorteurProjet> result = new ArrayList<>();
        porteurProjetRepository.findAll().forEach(result::add);
        return result;
    }

    public PorteurProjet get(Long id) {
        return porteurProjetRepository.findById(id).orElse(null);
    }

    public void add(PorteurProjet porteur) {
        porteurProjetRepository.save(porteur);
    }

    public void deleteById(Long id) {
        porteurProjetRepository.deleteById(id);
    }

    public void updatePorteurProjet( Long id, PorteurProjet porteurProjet) {
        porteurProjetRepository.save(porteurProjet);
    }

    /*
     * public PorteurProjet updatePorteurProjet(Long id, PorteurProjet
     * updatedPorteur) {
     * return porteurProjetRepository.findById(id)
     * .map(porteur -> {
     * porteur.setLogin(updatedPorteur.getLogin());
     * // mettre à jour autres champs selon besoin
     * return porteurProjetRepository.save(porteur);
     * }).orElseThrow(() -> new RuntimeException("PorteurProjet not found with id "
     * + id));
     * }
     */
}

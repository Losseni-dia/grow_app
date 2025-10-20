package grow.backend.controller;

import grow.backend.model.Campagne;
import grow.backend.service.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CampagneController {

    @Autowired
    private CampagneService campagneService;

    // Liste de toutes les campagnes
    @GetMapping("/campagnes")
    public String index(Model model) {
        List<Campagne> campagnes = campagneService.getAll();

        model.addAttribute("campagnes", campagnes);
        model.addAttribute("title", "Liste des campagnes");

        return "campagne/index"; // → templates/campagne/index.html
    }

    // Détail d'une campagne
    @GetMapping("/campagnes/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Campagne campagne = campagneService.get(id);

        model.addAttribute("campagne", campagne);
        model.addAttribute("title", "Fiche de la campagne : " + campagne.getLibelle());

        return "campagne/show"; // → templates/campagne/show.html
    }
}
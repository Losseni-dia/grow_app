package grow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import grow.backend.model.Projet;
import grow.backend.service.ProjetService;
import jakarta.websocket.server.PathParam;


@Controller
public class ProjetController {

    @Autowired
    private ProjetService service;

    @GetMapping("/projets")
    public String index(Model model) {
        List<Projet> projets = service.getAll();

        model.addAttribute("projets", projets);
        model.addAttribute("title", "Liste des projets");

        return "projet/index"; // Correspond à src/main/resources/templates/projet/index.html
    }

    @GetMapping("/projets/{id}")
    public String show(@PathVariable Long id, Model model) {
        if (id == null) {
            // Gérer cas id manquant, par ex. redirection ou message d'erreur
            return "redirect:/projets";
        }
        Projet projet = service.get(id);
        model.addAttribute("projet", projet);
        return "projet/show";
    }
 
}

    


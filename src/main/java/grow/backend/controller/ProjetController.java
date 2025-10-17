package grow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import grow.backend.model.Projet;
import grow.backend.service.ProjetService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

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

    @GetMapping("/projets/{id}/edit")
    public String edit(Model model, @PathVariable Long id, HttpServletRequest request) {
        Projet projet = service.get(id);
        model.addAttribute("projet", projet);

        // Génération du lien retour pour annulation
        String referrer = request.getHeader("Referer");
        if (referrer != null && !referrer.isEmpty()) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/projets/" + projet.getId());
        }
        return "projet/edit";
    }

    @GetMapping("/projets/create")
    public String create(Model model) {
        Projet projet = new Projet();
        
        model.addAttribute("projet", projet);

        return "projet/create";
    }

    @PostMapping("/projets/create")
    public String store(@Valid @ModelAttribute Projet projet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "projet/create";
        }
        service.add(projet);
        return "redirect:/projets/" + projet.getId();
    }


    @PutMapping("/projets/{id}/edit")
    public String update(@Valid @ModelAttribute Projet projet, BindingResult bindingResult, @PathVariable Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "projet/edit";
        }

        Projet existing = service.get(id);
        if (existing == null) {
            return "projet/index";
        }

        service.update(id, projet);

        return "redirect:/projets/" + projet.getId();
    }

 
}

    


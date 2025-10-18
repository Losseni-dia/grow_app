package grow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // pour la notificatication des actions

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

    @GetMapping("/projets/create")
    public String create(Model model) {
        if (!model.containsAttribute("projet")) {
            model.addAttribute("projet", new Projet());
            model.addAttribute("personnes", service.getAllPorteurProjets());
            model.addAttribute("sites", service.getAllSiteProjets());
        }
       
        return "projet/create";
    }

    @PostMapping("/projets/create")
    public String store(@Valid @ModelAttribute Projet projet, BindingResult bindingResult, Model model,
                        RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Échec de la création du projet !");
            model.addAttribute("personnes", service.getAllPorteurProjets());
            model.addAttribute("sites", service.getAllSiteProjets());
            return "projet/create";
        }

        service.add(projet);
        redirAttrs.addFlashAttribute("successMessage", "Projet créé avec succès.");

        return "redirect:/projets/" + projet.getId();
    }

    @GetMapping("/projets/{id}/edit")
    public String edit(Model model, @PathVariable Long id, HttpServletRequest request) {
        Projet projet = service.get(id);
        model.addAttribute("projet", projet);
        model.addAttribute("personnes", service.getAllPorteurProjets());
        model.addAttribute("sites", service.getAllSiteProjets());
        model.addAttribute("campagnes", projet.getCampagnes()); // ajoute explicitement la collection au modèle
        

        // Génération du lien retour pour annulation
        String referrer = request.getHeader("Referer");
        if (referrer != null && !referrer.isEmpty()) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/projets/" + projet.getId());
        }
        return "projet/edit";
    }

    @PutMapping("/projets/{id}/edit")
    public String update(@Valid @ModelAttribute Projet projet, BindingResult bindingResult, @PathVariable Long id,
                         Model model, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("personnes", service.getAllPorteurProjets());
            model.addAttribute("sites", service.getAllSiteProjets());
            model.addAttribute("campagnes", projet.getCampagnes()); // ajoute explicitement la collection au modèle
            model.addAttribute("errorMessage", "Échec de la modification du projet !");
            return "projet/edit";
        }
        Projet existing = service.get(id);
        if (existing == null) {
            return "projet/index";
        }

        service.update(id, projet);
        redirAttrs.addFlashAttribute("successMessage", "Projet modifié avec succès.");

        return "redirect:/projets/" + projet.getId();
    }
    
    @DeleteMapping("/projets/{id}")
	public String delete(@PathVariable long id, Model model, RedirectAttributes redirAttrs) {
	    Projet existing = service.get(id);
		
	    if(existing!=null) {		
            service.delete(id);
            redirAttrs.addFlashAttribute("successMessage", "Projet supprimé avec succès.");
	    } else {
            redirAttrs.addFlashAttribute("errorMessage", "Échec de la suppression du projet !");
        }
	    	    
	    return "redirect:/projets";
	}



 
}

    


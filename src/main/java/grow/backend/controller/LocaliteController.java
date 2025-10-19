package grow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import grow.backend.model.Localite;
import grow.backend.service.LocaliteService;


@Controller
public class LocaliteController {
    @Autowired
    LocaliteService service;

    @GetMapping("/localites")
    public String index2(Model model) {
        List<Localite> localites = service.getAll();

        model.addAttribute("localites", localites);
        model.addAttribute("title", "Liste des localités");

        return "localite/index";
    }

    @GetMapping("/localites/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Localite localite = service.get(id);

        model.addAttribute("localite", localite);
        model.addAttribute("title", "Fiche d'une localité");

        return "localite/show";
    }

}

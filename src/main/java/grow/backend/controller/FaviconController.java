package grow.backend.controller;
//Classe a supprimer lorsque j'ajouterai favicon. c'est juste pour éviter une erreur de démarrage
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FaviconController {
    @RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {
    }
}

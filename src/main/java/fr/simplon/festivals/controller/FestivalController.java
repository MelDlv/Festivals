package fr.simplon.festivals.controller;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FestivalController {
    @RequestMapping("/")
    public String Acceuil(Model model) {
        return "Acceuil";
    }

    @RequestMapping("/AjouterFestival")
    public String AjouterFestival(Model model) {
        return "AjouterFestival";
    }

    @RequestMapping("/EditerFestival")
    public String EditerFestival(Model model) {
        return "EditerFestival";
    }
}

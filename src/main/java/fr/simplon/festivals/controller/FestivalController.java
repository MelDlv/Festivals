package fr.simplon.festivals.controller;
import fr.simplon.festivals.dao.impl.FestivalDAO;
import fr.simplon.festivals.dao.impl.FestivalDAOImpl;
import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FestivalController {

    @Autowired
    private FestivalRepository festivalRepository;
    @Autowired
    private FestivalDAOImpl festivalDAO;


    @GetMapping("/festivals")
    @ResponseBody
    public List<Festival> getFestivals() {
        return festivalDAO.getAllFestivals();
    }

    @GetMapping("/")
    public String Accueil(Model model) {
        List<Festival> festivals = festivalRepository.findAll();
        model.addAttribute("festivals", festivals);
        return "Accueil";
    }

    @RequestMapping("/AjouterFestival")
    public String AjouterFestival(Model model) {
        model.addAttribute("festival", new Festival());
        return "AjouterFestival";
    }

    @Autowired
    private FestivalDAO FestivalDAO;

    @PostMapping("/AjouterFestival") // Mapping POST pour enregistrer un festival
    public String saveFestival(@ModelAttribute Festival festival) {
        festivalDAO.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/"; // Rediriger vers la page d'accueil après l'enregistrement
    }

    @GetMapping("/EditerFestival/{id}")
    public String EditerFestival(@PathVariable("id") Long id, Model model) {
        model.addAttribute("festival", festivalRepository.findById(id).orElse(null));
        return "EditerFestival";
    }

    @PostMapping("/update/{id}")
    public String updateFestival(@PathVariable("id") Long id, Festival festival, Model model) {
        festival.setId(id);
        festivalRepository.save(festival);
        return "redirect:/";
    }
}

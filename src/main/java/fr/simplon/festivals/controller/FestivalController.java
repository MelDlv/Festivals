package fr.simplon.festivals.controller;

import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FestivalController {

    @Autowired
    private FestivalRepository festivalRepository;

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

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


/**
 * Contrôleur pour les opérations liées aux festivals.
 */
@Controller
public class FestivalController {

    /**
     * Repository pour accéder aux festivals.
     */
    @Autowired
    private FestivalRepository festivalRepository;

    /**
     * DAO pour les opérations CRUD sur les festivals.
     */
    @Autowired
    private FestivalDAOImpl festivalDAO;

    /**
     * @return La liste de tous les festivals enregistrés.
     */
    @GetMapping("/festivals")
    @ResponseBody
    public List<Festival> getFestivals() {
        return festivalDAO.getAllFestivals();
    }

    /**
     * Affiche la page d'accueil.
     *
     * @param model Le modèle pour la vue.
     * @return Le nom de la vue pour la page d'accueil.
     */
    @GetMapping("/")
    public String Accueil(Model model) {
        List<Festival> festivals = festivalRepository.findAll();
        model.addAttribute("festivals", festivals);
        return "Accueil";
    }

    /**
     * Affiche le formulaire pour ajouter un festival.
     *
     * @param model Le modèle pour la vue.
     * @return Le nom de la page html pour le formulaire d'ajout.
     */
    @RequestMapping("/AjouterFestival")
    public String AjouterFestival(Model model) {
        model.addAttribute("festival", new Festival());
        return "AjouterFestival";
    }

    /**
     * Enregistre un nouveau festival.
     *
     * @param festival Le festival à enregistrer.
     * @return La redirection vers la page d'accueil après l'enregistrement.
     */
    @PostMapping("/AjouterFestival")
    public String saveFestival(@ModelAttribute Festival festival) {
        festivalDAO.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

    /**
     * Affiche le formulaire pour éditer un festival.
     *
     * @param id L'identifiant du festival à éditer.
     * @param model Le modèle pour la vue.
     * @return La page html pour le formulaire d'édition.
     */
    @GetMapping("/EditerFestival/{id}")
    public String EditerFestival(@PathVariable("id") Long id, Model model) {
        model.addAttribute("festival", festivalRepository.findById(id).orElse(null));
        return "EditerFestival";
    }

    /**
     * Met à jour un festival.
     *
     * @param id L'identifiant du festival à mettre à jour.
     * @param festival Le festival avec les nouvelles valeurs.
     * @param model Le modèle pour la vue.
     * @return La redirection vers la page d'accueil après la mise à jour.
     */
    @PostMapping("/update/{id}")
    public String updateFestival(@PathVariable("id") Long id, Festival festival, Model model) {
        festival.setId(id);
        festivalRepository.save(festival);
        return "redirect:/";
    }
}

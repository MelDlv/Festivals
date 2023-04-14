package fr.simplon.festivals.dao.impl;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

/**
 *Cette classe implémente l'interface FestivalDAO et fournit les méthodes pour
 *effectuer les opérations CRUD sur les festivals.
 */
@Repository
public class FestivalDAOImpl implements FestivalDAO {

    /**
     *Injection de dépendance pour le Repository de la classe Festival.
     */
    @Autowired
    private FestivalRepository festivalRepository;

    /**
     *Enregistre un nouveau festival avec les informations fournies.
     *@param nom le nom du festival
     *@param ville la ville où le festival a lieu
     *@param lieu l'emplacement exact du festival
     *@param debut la date de début du festival
     *@param fin la date de fin du festival
     *@param lat la latitude de l'emplacement du festival
     *@param lon la longitude de l'emplacement du festival
     */
    @Override
    public void saveFestival(String nom, String ville, String lieu, LocalDate debut, LocalDate fin, Double lat, Double lon) {
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setLat(lat);
        festival.setLon(lon);
        festivalRepository.save(festival);
    }

    /**
     *Récupère une liste de tous les festivals enregistrés dans la base de données.
     *@return liste de tous les festivals
     */
    @Override
    public List<Festival> getAllFestivals(){
        return festivalRepository.findAll();
    }

    /**
     *Récupère le festival correspondant à l'ID donné.
     *@param id l'ID du festival à récupérer
     *@return le festival correspondant à l'ID donné, ou null s'il n'y a pas de correspondance
     */
    @Override
    public Festival getFestivalById(Long id) {
        return festivalRepository.findById(id).orElse(null);
    }
}

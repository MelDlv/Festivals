package fr.simplon.festivals.dao.impl;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public class FestivalDAOImpl implements FestivalDAO {

    @Autowired
    private FestivalRepository festivalRepository;



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

    @Override
    public List<Festival> getAllFestivals(){
        return festivalRepository.findAll();
    }

    @Override
    public Festival getFestivalById(Long id) {
        return festivalRepository.findById(id).orElse(null);
    }
}

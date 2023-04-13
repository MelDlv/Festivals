package fr.simplon.festivals.dao.impl;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

public class FestivalDAOImpl implements FestivalDAO {

    @Autowired
    private fr.simplon.festivals.dao.impl.FestivalRepository festivalRepository;

    @Override
    public void saveFestival(String nom, String ville, String lieu, LocalDate debut, LocalDate fin) {
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festivalRepository.save(festival);
    }
}

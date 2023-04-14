package fr.simplon.festivals.dao.impl;
import fr.simplon.festivals.entity.Festival;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface FestivalDAO
{

    void saveFestival(String nom, String ville, String lieu, LocalDate debut, LocalDate fin, Double lat, Double lon);

    List<Festival> getAllFestivals();

    Festival getFestivalById(Long id);
}

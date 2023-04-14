package fr.simplon.festivals.dao.impl;
import fr.simplon.festivals.entity.Festival;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface FestivalDAO
{
    /**
     * Enregistre un Festival en utilisant les paramètres fournis.
     *
     * @param nom Le nom du Festival
     * @param ville La ville où se déroule le Festival
     * @param lieu Le lieu
     * @param debut La date de début
     * @param fin La date de fin .
     * @param lat La latitude
     * @param lon La longitude
     */
    void saveFestival(String nom, String ville, String lieu, LocalDate debut, LocalDate fin, Double lat, Double lon);

    /**
     * Récupère une liste de tous les Festivals enregistrés.
     *
     * @return La liste de tous les Festivals enregistrés.
     */
    List<Festival> getAllFestivals();

    /**
     * Récupère un Festival enregistré en utilisant son identifiant.
     *
     * @param id L'identifiant unique du Festival
     * @return Le Festival récupéré correspondant à l'identifiant fourni.
     */
    Festival getFestivalById(Long id);

}

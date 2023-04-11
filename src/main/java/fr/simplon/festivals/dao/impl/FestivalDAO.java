package fr.simplon.festivals.dao.impl;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface FestivalDAO
{
    void saveFestival(String nom, String ville, String lieu, Date debut, Date fin);
}

package fr.simplon.festivals.dao.impl;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface FestivalDAO
{
    void saveFestival(String nom, String ville, String lieu, LocalDate debut, LocalDate fin);
}

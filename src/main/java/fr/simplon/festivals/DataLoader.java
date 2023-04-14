package fr.simplon.festivals;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.List;


/**
 *Cette classe sert à charger des données de festivals dans la base de données
 *Elle implémente l'interface ApplicationRunner de Spring Boot pour être exécutée au démarrage de l'application.
 */
@Component
public class DataLoader implements ApplicationRunner {

    /**
     *Injection de dépendance pour le Repository de la classe Festival.
     */
    private final FestivalRepository mFestivalRepository;

    @Autowired
    public DataLoader(FestivalRepository pFestivalRepository) {
        this.mFestivalRepository = pFestivalRepository;
    }

    /**
     *Charge des données de festivals dans la base de données.
     *@param args les arguments passés à l'application
     *@throws Exception si une exception est levée pendant le chargement des données
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (mFestivalRepository.count() == 0) {
            ClassPathResource resource = new ClassPathResource("/static/festivals.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Festival> festivals = objectMapper.readValue(
                    resource.getInputStream(), new TypeReference<List<Festival>>() {
                    });
            mFestivalRepository.saveAll(festivals);
        }
    }
}
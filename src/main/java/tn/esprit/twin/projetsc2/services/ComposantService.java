package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.repository.CommandeRepo;
import tn.esprit.twin.projetsc2.repository.ComposantRepo;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ComposantService implements ComposantInterface {

    private final CommandeRepo commandeRepo;
    private ComposantRepo composantRepo;
private MenuRepo menuRepo;
    @Override
    public List<Composant> retrieveAllComposants() {
        return composantRepo.findAll();
    }

    @Override
    public Composant retrieveComposant(Long idComposant) {
        return composantRepo.findById(idComposant).orElse(null);
    }

    @Override
    public Composant addComposant(Composant c) {
        return composantRepo.save(c);
    }

    @Override
    public Composant updateComposant(Composant c) {
        return composantRepo.save(c);
    }

    @Override
    public void removeComposant(Long idComposant) {
        composantRepo.deleteById(idComposant);

    }

    @Override
    public List<Composant> addComposant(List<Composant> composants) {
        return composantRepo.saveAll(composants);
    }

    @Scheduled(cron="0 0 9 31 12 ?")
    @Override
    public void addComposantPrice() {
        List<Composant> composants= composantRepo.findAll();
        for(Composant c: composants){
            if(c.getDetailComposant().getTypeComposant().equals(TypeComposant.VIANDE_ROUGE)){
                float newPrice= c.getPrix() + 0.05f;
                c.setPrix(newPrice);
                composantRepo.save(c);
            }
        }

    }


}

package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.repository.ComposantRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class ComposantService implements ComposantInterface {

    private ComposantRepo composantRepo;
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
}

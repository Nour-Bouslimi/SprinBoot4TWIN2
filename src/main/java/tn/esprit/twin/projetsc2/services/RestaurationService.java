package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Restauration;
import tn.esprit.twin.projetsc2.entities.TypeChef;
import tn.esprit.twin.projetsc2.repository.RestaurationRepo;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class RestaurationService implements RestaurationInterface {
    @Autowired
    private RestaurationRepo restaurationRepo;
    @Override
    public List<Restauration> retrieveAllRestaurations() {
        return restaurationRepo.findAll();
    }

    @Override
    public Restauration retrieveRestauration(Long idRestauration) {
        return restaurationRepo.findById(idRestauration).orElse(null);
    }

    @Override
    public Restauration addRestauration(Restauration resto) {
        return restaurationRepo.save(resto);
    }

    @Override
    public Restauration updateRestauration(Restauration resto) {
        return restaurationRepo.save(resto);
    }

    @Override
    public void removeRestauration(Long idRestauration) {
        restaurationRepo.deleteById(idRestauration);
    }

    @Override
    public List<Restauration> addRestaurations(List<Restauration> restaurations) {
        return restaurationRepo.saveAll(restaurations);
    }

    @Override
    public List<Restauration> getRestaurantsNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlaces, LocalDate dateCreation) {
        return restaurationRepo.findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(nbPlaces, dateCreation);
    }

    @Override
    public List<ChefCuisinier> getChefsCuisiniers1EtoileByRestauration(Long idRestauration, TypeChef typeChef) {
        return restaurationRepo.getChefsCuisiniers1EtoileByRestauration(idRestauration, typeChef);
    }
}

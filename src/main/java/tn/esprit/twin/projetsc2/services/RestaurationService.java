package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.*;
import tn.esprit.twin.projetsc2.repository.ChaineRestaurationRepo;
import tn.esprit.twin.projetsc2.repository.RestaurationRepo;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class RestaurationService implements RestaurationInterface {

    private RestaurationRepo restaurationRepo;
    private ChaineRestaurationRepo chaineRestaurationRepo;
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

    @Override
    public Restauration affecterRestaurantAChaineRestauration(String nomRestaurant, Long idChaine) {
         Restauration restauration=restaurationRepo.findByNom(nomRestaurant);
        ChaineRestauration chaine = chaineRestaurationRepo.findById(idChaine).orElse(null);

        restauration.setChaineRestauration(chaine);
        return restaurationRepo.save(restauration);



    }

    @Override
    public Restauration ajoutRestaurantEtMenuAssocies(Restauration restaurant) {
        //prix doit etre initialisé dans les menus associés au restaurant à 0
        List<Menu> menus = restaurant.getMenus();
        menus.forEach(m -> m.setPrixTotal(0.0F));
        restaurant.setMenus(menus);
        return restaurationRepo.save(restaurant);
    }
}

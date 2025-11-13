package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Restauration;
import tn.esprit.twin.projetsc2.entities.TypeChef;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RestaurationInterface {

    List<Restauration> retrieveAllRestaurations();
    public Restauration retrieveRestauration(Long idRestauration);
    Restauration addRestauration(Restauration resto);
    Restauration updateRestauration(Restauration resto);
    void removeRestauration(Long idRestauration);
    List<Restauration> addRestaurations(List<Restauration> restaurations);
    List<Restauration> getRestaurantsNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlaces, LocalDate dateCreation);
    List<ChefCuisinier>getChefsCuisiniers1EtoileByRestauration(Long idRestauration, TypeChef typeChef);
    Restauration affecterRestaurantAChaineRestauration(String nomRestaurant, Long idChaine );
    Restauration ajoutRestaurantEtMenuAssocies(Restauration restaurant);

}

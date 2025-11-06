package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Restauration;

import java.util.List;

public interface RestaurationInterface {

    List<Restauration> retrieveAllRestaurations();
    public Restauration retrieveRestauration(Long idRestauration);
    Restauration addRestauration(Restauration resto);
    Restauration updateRestauration(Restauration resto);
    void removeRestauration(Long idRestauration);
    List<Restauration> addRestaurations(List<Restauration> restaurations);
}

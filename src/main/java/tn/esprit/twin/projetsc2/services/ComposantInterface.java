package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Composant;

import java.util.List;

public interface ComposantInterface {
    List<Composant> retrieveAllComposants();
    public Composant retrieveComposant(Long idComposant);
    Composant addComposant(Composant c);
    Composant updateComposant(Composant c);
    void removeComposant(Long idComposant);
    List<Composant> addComposant(List<Composant> composants);
}

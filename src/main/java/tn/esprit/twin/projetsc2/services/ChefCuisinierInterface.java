package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Client;

import java.util.List;

public interface ChefCuisinierInterface {

    List<ChefCuisinier> retrieveAllChefs();
    public ChefCuisinier retrieveChef(Long idChefCuisinier);
    ChefCuisinier addChef(ChefCuisinier c);
    ChefCuisinier updateChef(ChefCuisinier c);
    void removeChef(Long idChefCuisinier);
    List<ChefCuisinier> addChef(List<ChefCuisinier> chefCuisiniers);
}

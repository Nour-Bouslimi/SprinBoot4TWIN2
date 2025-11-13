package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Client;

import java.util.List;

public interface ChefCuisinierInterface {

    List<ChefCuisinier> retrieveAllChefs();
    public ChefCuisinier retrieveChef(Long idChefCuisinier);
    ChefCuisinier addChef(ChefCuisinier c);
    ChefCuisinier updateChef(ChefCuisinier c,Long idChefCuisinier);
    void removeChef(Long idChefCuisinier);
    List<ChefCuisinier> addChefs(List<ChefCuisinier> chefCuisiniers);
    ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu);
    ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long
            idChefCuisinier);
}

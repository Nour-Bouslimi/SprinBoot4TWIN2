package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.entities.TypeMenu;

import java.util.List;
import java.util.Set;

public interface MenuInterface {

    List<Menu> retrieveAlMenus();
    public Menu retrieveMenu(Long idMenu);
    Menu addMenu(Menu m);
    Menu updateMenu(Menu m);
    void removeMenu(Long idMenu);
    List<Menu> addMenus(List<Menu> menus);
    List<Menu>getByTypeMenuAndComposantsPrixGreaterThan(TypeMenu typeMenu, float prixMin);
    List<String>getMenuNamesByTypeMenuOrderByPrixTotalDesc(TypeMenu typeMenu);
    List<Menu>getMenusByTypeComposant(TypeComposant typeComposant);
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
}

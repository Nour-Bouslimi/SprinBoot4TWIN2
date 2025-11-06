package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Menu;

import java.util.List;

public interface MenuInterface {

    List<Menu> retrieveAlMenus();
    public Menu retrieveMenu(Long idMenu);
    Menu addMenu(Menu m);
    Menu updateMenu(Menu m);
    void removeMenu(Long idMenu);
    List<Menu> addMenus(List<Menu> menus);
}

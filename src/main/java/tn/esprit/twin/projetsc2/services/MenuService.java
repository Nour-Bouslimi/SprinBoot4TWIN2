package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.entities.TypeMenu;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class MenuService implements MenuInterface {

    @Autowired
    private MenuRepo menuRepo;
    @Override
    public List<Menu> retrieveAlMenus() {
        return menuRepo.findAll();
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepo.findById(idMenu).orElse(null);
    }

    @Override
    public Menu addMenu(Menu m) {
        return menuRepo.save(m);
    }

    @Override
    public Menu updateMenu(Menu m) {
        return menuRepo.save(m);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepo.deleteById(idMenu);

    }

    @Override
    public List<Menu> addMenus(List<Menu> menus) {
        return menuRepo.saveAll(menus);
    }

    @Override
    public List<Menu> getByTypeMenuAndComposantsPrixGreaterThan(TypeMenu typeMenu, float prixMin) {
        return menuRepo.findByTypeMenuAndComposantsPrixGreaterThan(typeMenu, prixMin);
    }

    @Override
    public List<String> getMenuNamesByTypeMenuOrderByPrixTotalDesc(TypeMenu typeMenu) {
        return menuRepo.findMenuNamesByTypeMenuOrderByPrixTotalDesc(typeMenu);
    }

    @Override
    public List<Menu> getMenusByTypeComposant(TypeComposant typeComposant) {
        return menuRepo.findMenusByTypeComposant(typeComposant);
    }

    @Override
    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        Menu menu = menuRepo.findById(idMenu).orElse(null);
        if(menu !=null){
            menu.getComposants().addAll((composants));
            float prixTotal = 0;
            for(Composant c: menu.getComposants()){
                prixTotal +=c.getPrix();
            }
            menu.setPrixTotal(prixTotal);
            if(menu.getPrixTotal()<=20){
                return menuRepo.save(menu);
            }

        }
        return null;
    }

}

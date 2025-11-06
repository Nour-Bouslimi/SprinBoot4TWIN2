package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.entities.TypeMenu;
import tn.esprit.twin.projetsc2.services.MenuInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuC {
    @Autowired
    MenuInterface menuInterface;

    @PostMapping("/addMenu")
    public Menu addMenu(@RequestBody Menu menu){
        return menuInterface.addMenu(menu);
    }

    @PostMapping("/addListMenu")
    public List<Menu> addListMenu(@RequestBody List<Menu> menus){
        return menuInterface.addMenus(menus);
    }

    @GetMapping("/getAllMenus")
    public List<Menu> getAllMenus(){
        return menuInterface.retrieveAlMenus();
    }

    @GetMapping("/getMenu/{idMenu}")
    public Menu getMenu(@PathVariable Long idMenu){
        return menuInterface.retrieveMenu(idMenu);
    }

    @PutMapping("/updateMenu/{idMenu}")
    public Menu updateMenu(@RequestBody Menu menu, @PathVariable Long idMenu){
        Menu m=menuInterface.retrieveMenu(idMenu);
        if(m!=null){
            m.setLibelleMenu(menu.getLibelleMenu());
            m.setTypeMenu(menu.getTypeMenu());
            m.setPrixTotal(menu.getPrixTotal());
            return menuInterface.updateMenu(m);
        } else {
            throw new IllegalArgumentException("Menu with id " + idMenu + " does not exist.");
        }

    }
    @DeleteMapping("/deleteMenu/{idMenu}")
    public void deleteMenu(@PathVariable Long idMenu){
        menuInterface.removeMenu(idMenu);
    }
    @GetMapping("/getByTypeMenuAndComposantsPrixGreaterThan/{typeMenu}/{prixMin}")
    public List<Menu> getByTypeMenuAndComposantsPrixGreaterThan(@PathVariable String typeMenu, @PathVariable float prixMin){
        try{
            TypeMenu tm = TypeMenu.valueOf(typeMenu.toUpperCase());
            return menuInterface.getByTypeMenuAndComposantsPrixGreaterThan(tm, prixMin);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException("TypeMenu invalide. Utilisez PETIT_DEJEUNER, DEJEUNER, DINER'.");
        }
    }
    @GetMapping("/getMenuNamesByTypeMenuOrderByPrixTotalDesc/{typeMenu}")
    public List<String> getMenuNamesByTypeMenuOrderByPrixTotalDesc(@PathVariable String typeMenu){
        try{
            TypeMenu tm = TypeMenu.valueOf(typeMenu.toUpperCase());
            return menuInterface.getMenuNamesByTypeMenuOrderByPrixTotalDesc(tm);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException("TypeMenu invalide. Utilisez PETIT_DEJEUNER, DEJEUNER, DINER'.");
        }
    }
    @GetMapping("/getMenusByTypeComposant/{typeComposant}")
    public List<Menu> getMenusByTypeComposant(@PathVariable String typeComposant){
        try{
            TypeComposant tc = TypeComposant.valueOf(typeComposant.toUpperCase());
            return menuInterface.getMenusByTypeComposant(tc);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException("TypeComposant invalide. Utilisez VVIANDE_BLANCHE, VIANDE_ROUGE,  CEREALE'.");
        }
    }


}

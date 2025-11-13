package tn.esprit.twin.projetsc2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.entities.TypeMenu;
import tn.esprit.twin.projetsc2.services.MenuInterface;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
@Tag(name = "Gestion des Menus", description = "Opérations liées aux menus")
public class MenuC {
    @Autowired
    MenuInterface menuInterface;
@Operation(summary = "Ajouter un nouveau menu", description = "Cette opération permet d'ajouter un nouveau menu à la base de données.")
    @PostMapping("/addMenu")
    public Menu addMenu(@RequestBody Menu menu){
        return menuInterface.addMenu(menu);
    }
@Operation(summary = "Ajouter une liste de menus", description = "Ajoute une liste de menus dans le système")
    @PostMapping("/addListMenu")
    public List<Menu> addListMenu(@RequestBody List<Menu> menus){
        return menuInterface.addMenus(menus);
    }
@Operation(summary = "récupérer tous les menus", description = "Retourne la liste de tous les menus")
    @GetMapping("/getAllMenus")
    public List<Menu> getAllMenus(){

        return menuInterface.retrieveAlMenus();
    }
@Operation(summary = "Récupérer un menu par ID", description = "Retourne les détails d'un menu spécifique en fonction de son ID.")
    @GetMapping("/getMenu/{idMenu}")
    public Menu getMenu(@PathVariable Long idMenu){
        return menuInterface.retrieveMenu(idMenu);
    }
@Operation(summary = "Mettre à jour un menu existant", description = "Met à jour les informations d'un menu en fonction de son ID.")
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
    @Operation(summary = "Supprimer un menu", description = "Supprime un menu de la base de données en fonction de son ID.")
    @DeleteMapping("/deleteMenu/{idMenu}")
    public void deleteMenu(@PathVariable Long idMenu){
        menuInterface.removeMenu(idMenu);
    }
    @Operation(summary = "Récupérer des menus par type et prix minimum des composants", description = "Retourne une liste de menus filtrés par type de menu et dont le prix total des composants est supérieur à un montant donné.")
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
    @Operation(summary = "Récupérer les noms des menus par type ordonnés par prix total décroissant", description = "Retourne une liste des noms des menus filtrés par type de menu, ordonnés par prix total décroissant.")
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
    @Operation(summary = "Récupérer des menus par type de composant", description = "Retourne une liste de menus contenant un type de composant spécifique.")
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
/********************** affectation *******************/
@PostMapping("/ajoutComposantsEtMiseAjourPrixMenu/{idMenu}" )
    public Menu ajoutComposantsEtMiseAjourPrixMenu(@RequestBody Set<Composant> composants, @PathVariable("idMenu") Long idMenu ){
        return menuInterface.ajoutComposantsEtMiseAjourPrixMenu(composants, idMenu);
    }

}

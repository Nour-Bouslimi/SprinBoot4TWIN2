package tn.esprit.twin.projetsc2.controller;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.TypeChef;
import tn.esprit.twin.projetsc2.services.ChefCuisinierInterface;
import tn.esprit.twin.projetsc2.services.RestaurationInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chefCuisinier")
public class ChefCuisinierC {
     @Autowired
     ChefCuisinierInterface chefCuisinierInterface;
     @Autowired
     RestaurationInterface restaurationInterface;


     @PostMapping("/addChefCuisinier")
        public ChefCuisinier addChefCuisinier(@RequestBody ChefCuisinier chefCuisinier){
            return chefCuisinierInterface.addChef(chefCuisinier);
        }

        @PostMapping("/addListChefsCuisiniers")
        public List<ChefCuisinier> addListChefsCuisiniers(@RequestBody List<ChefCuisinier> chefsCuisiniers){
            return chefCuisinierInterface.addChefs(chefsCuisiniers);
        }

        @GetMapping("/getAllChefsCuisiniers")
        public List<ChefCuisinier> getAllChefsCuisiniers(){
            return chefCuisinierInterface.retrieveAllChefs();
        }
        @GetMapping("/getChefCuisinierById/{idChefCuisinier}")
        public ChefCuisinier getChefCuisinierById(@PathVariable Long idChefCuisinier){
            return chefCuisinierInterface.retrieveChef(idChefCuisinier);
        }
        @PutMapping("/updateChefCuisinier/{idChefCuisinier}")
        public ChefCuisinier updateChefCuisinier(@RequestBody ChefCuisinier chefCuisinier, @PathVariable Long idChefCuisinier){
            ChefCuisinier cc=chefCuisinierInterface.retrieveChef(idChefCuisinier);
            if(cc!=null){
                cc.setNom(chefCuisinier.getNom());
                cc.setPrenom(chefCuisinier.getPrenom());
                cc.setTypeChef(chefCuisinier.getTypeChef());

                return chefCuisinierInterface.updateChef(cc,idChefCuisinier);
            } else {
                throw new IllegalArgumentException("Chef Cuisinier with id " + idChefCuisinier + " does not exist.");
            }
        }

        @DeleteMapping("/deleteChefCuisinier/{idChefCuisinier}")
        public void deleteChefCuisinier(@PathVariable Long idChefCuisinier){
            chefCuisinierInterface.removeChef(idChefCuisinier);
        }


     @GetMapping("/getChefsCuisiniers1EtoileByRestaurationTypeRestauration/{typeRestauration}")
     public List<ChefCuisinier> getChefsCuisiniers1EtoileByRestaurationTypeRestauration(@PathVariable Long idRestauration, @PathVariable String typeChefCuisinier){
          try {
               TypeChef chefEnum = TypeChef.valueOf(typeChefCuisinier.toUpperCase());
               return restaurationInterface.getChefsCuisiniers1EtoileByRestauration(idRestauration, chefEnum);

          } catch (Exception e) {
               throw new RuntimeException("vérifiez le type de chef cuisinier");
          }


     }

     /************* affectation ***************/

     @GetMapping("/chefCuisinierAffecteRestauration/{idChefCuisinier}/{idMenu}")
    public ChefCuisinier affecterChefCuisinierARestauration(@PathVariable Long idChefCuisinier, @PathVariable Long idMenu){
         return chefCuisinierInterface.affecterChefCuisinierAMenu(idChefCuisinier, idMenu);
    }
    @GetMapping("/chefCuisinierDesaffecteRestauration/{idMenu}/{idChefCuisinier}")
    public ChefCuisinier desaffecterChefCuisinierDuRestauration(@PathVariable Long idMenu, @PathVariable Long idChefCuisinier){
         return chefCuisinierInterface.desaffecterChefCuisinierDuMenu(idMenu, idChefCuisinier);
    }
}

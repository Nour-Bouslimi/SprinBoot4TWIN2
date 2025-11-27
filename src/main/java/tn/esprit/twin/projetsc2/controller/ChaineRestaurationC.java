package tn.esprit.twin.projetsc2.controller;


import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.services.ChaineRestaurationInterface;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chaineRestauration")
public class ChaineRestaurationC {

     ChaineRestaurationInterface chaineRestaurationInterface;

     @PostMapping("/addChaineRestauration")
     public ChaineRestauration addChaineRestauration(@RequestBody ChaineRestauration chaineRestauration){
         return chaineRestaurationInterface.addChaineRestauration(chaineRestauration);
     }

     @PostMapping("/addListChainesRestauration")
        public List<ChaineRestauration> addListChainesRestauration(@RequestBody List<ChaineRestauration> chainesRestauration){
            return chaineRestaurationInterface.addChaineRestaurations(chainesRestauration);
        }

       @GetMapping("/getAllChainesRestauration")
        public List<ChaineRestauration> getAllChainesRestauration(){
            return chaineRestaurationInterface.retrieveAllChaineRestauration();
        }

        @GetMapping("/getChaineRestaurationById/{idChaineRestauration}")
        public ChaineRestauration getChaineRestaurationById(@PathVariable Long idChaineRestauration){
            return chaineRestaurationInterface.retrieveChaineRestauration(idChaineRestauration);
        }

        @PutMapping("/updateChaineRestauration/{idChaineRestauration}")
        public ChaineRestauration updateChaineRestauration(@RequestBody ChaineRestauration chaineRestauration, @PathVariable Long idChaineRestauration){
            ChaineRestauration cr=chaineRestaurationInterface.retrieveChaineRestauration(idChaineRestauration);
            if(cr!=null){
                cr.setLibelle(chaineRestauration.getLibelle());
                cr.setDateCreation(chaineRestauration.getDateCreation());

                return chaineRestaurationInterface.updateChaineRestauration(cr,idChaineRestauration);
            } else {
                throw new IllegalArgumentException("Chaine Restauration with id " + idChaineRestauration + " does not exist.");
            }
        }

        @DeleteMapping("/deleteChaineRestauration/{idChaineRestauration}")
        public void deleteChaineRestauration(@PathVariable Long idChaineRestauration){
            chaineRestaurationInterface.removeChaineRestauration(idChaineRestauration);
        }















}

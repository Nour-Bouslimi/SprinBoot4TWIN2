package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.services.ComposantInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/composant")
public class ComposantC {
    @Autowired
    ComposantInterface composantInterface;

    @PostMapping("/addComposant")
    public Composant addComposant(@RequestBody Composant composant){
        return composantInterface.addComposant(composant);
    }
    @PostMapping("/addListComposants")
    public List<Composant> addListComposants(@RequestBody List<Composant> composants){
        return composantInterface.addComposant(composants);
    }

    @GetMapping("/getAllComposants")
    public List<Composant> getAllComposants(){
        return composantInterface.retrieveAllComposants();
    }
    @GetMapping("/getComposantById/{idComposant}")
    public Composant getComposantById(@PathVariable Long idComposant){
        return composantInterface.retrieveComposant(idComposant);
    }
    @PutMapping("/updateComposant/{idComposant}")
    public Composant updateComposant(@RequestBody Composant composant, @PathVariable Long idComposant){
        Composant c=composantInterface.retrieveComposant(idComposant);
        if(c!=null){
            c.setNomComposant(composant.getNomComposant());
            c.setPrix(composant.getPrix());
            return composantInterface.updateComposant(c);
        } else {
            throw new IllegalArgumentException("Composant with id " + idComposant + " does not exist.");
        }
    }

    @DeleteMapping("/deleteComposant/{idComposant}")
    public void deleteComposant(@PathVariable Long idComposant){
        composantInterface.removeComposant(idComposant);
    }









}

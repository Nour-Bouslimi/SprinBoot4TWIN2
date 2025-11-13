package tn.esprit.twin.projetsc2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.services.ComposantInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/composant")
@Tag(name = "Gestion des Composants", description = "Opérations liées aux composants")
public class ComposantC {
    @Autowired
    ComposantInterface composantInterface;
@Operation(summary = "Ajouter un nouveau composant", description = "Cette opération permet d'ajouter un nouveau composant à la base de données.")
    @PostMapping("/addComposant")
    public Composant addComposant(@RequestBody Composant composant){
        return composantInterface.addComposant(composant);
    }
    @Operation(summary = "Ajouter une liste de composants", description = "Ajoute une liste de composants dans le système")
    @PostMapping("/addListComposants")
    public List<Composant> addListComposants(@RequestBody List<Composant> composants){
        return composantInterface.addComposant(composants);
    }
@Operation(summary = "Récupérer tous les composants", description = "Retourne la liste de tous les composants")
    @GetMapping("/getAllComposants")
    public List<Composant> getAllComposants(){
        return composantInterface.retrieveAllComposants();
    }
    @Operation(summary = "Récupérer un composant par ID", description = "Retourne les détails d'un composant spécifique en fonction de son ID.")
    @GetMapping("/getComposantById/{idComposant}")
    public Composant getComposantById(@PathVariable Long idComposant){
        return composantInterface.retrieveComposant(idComposant);
    }
    @Operation(summary = "Mettre à jour un composant existant", description = "Met à jour les informations d'un composant en fonction de son ID.")
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
@Operation(summary = "Supprimer un composant", description = "Supprime un composant de la base de données en fonction de son ID.")
    @DeleteMapping("/deleteComposant/{idComposant}")
    public void deleteComposant(@PathVariable Long idComposant){
        composantInterface.removeComposant(idComposant);
    }









}

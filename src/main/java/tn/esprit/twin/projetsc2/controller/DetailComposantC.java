package tn.esprit.twin.projetsc2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.DetailComposant;
import tn.esprit.twin.projetsc2.services.DetailComposantInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detailComposant")
@Tag(name = "Gestion des Détails des Composants", description = "Opérations liées aux détails des composants")
public class DetailComposantC {
    @Autowired
    DetailComposantInterface detailComposantInterface;
@Operation(summary = "Ajouter un nouveau détail de composant", description = "Cette opération permet d'ajouter un nouveau détail de composant à la base de données.")
    @PostMapping("/addDetailComposant")
    public DetailComposant addDetailComposant(@RequestBody DetailComposant detailComposant){
        return detailComposantInterface.addDetail(detailComposant);
    }
    @Operation(summary = "Ajouter une liste de détails de composants", description = "Ajoute une liste de détails de composants dans le système")
    @PostMapping("/addListDetailComposants")
    public List<DetailComposant> addListDetailComposants(@RequestBody List<DetailComposant> detailComposants){
        return detailComposantInterface.addDetails(detailComposants);
    }
    @Operation(summary = "Récupérer tous les détails des composants", description = "Retourne la liste de tous les détails des composants")
    @GetMapping("/getAllDetailComposants")
    public List<DetailComposant> getAllDetailComposants(){
        return detailComposantInterface.retrieveAlldetails();
    }
@Operation(summary = "Récupérer un détail de composant par ID", description = "Retourne les détails d'un composant spécifique en fonction de son ID.")
    @GetMapping("/getDetailComposantById/{idDetailComposant}")
    public DetailComposant getDetailComposantById(@PathVariable Long idDetailComposant){
        return detailComposantInterface.retrieveDetail(idDetailComposant);
    }
@Operation(summary = "Mettre à jour un détail de composant existant", description = "Met à jour les informations d'un détail de composant en fonction de son ID.")
    @PutMapping("/updateDetailComposant/{idDetailComposant}")
    public DetailComposant updateDetailComposant(@RequestBody DetailComposant detailComposant, @PathVariable Long idDetailComposant){
        DetailComposant dc=detailComposantInterface.retrieveDetail(idDetailComposant);
        if(dc!=null){
            dc.setImc(detailComposant.getImc());
            dc.setTypeComposant(detailComposant.getTypeComposant());
            return detailComposantInterface.updateDetail(dc);
        } else {
            throw new IllegalArgumentException("Detail Composant with id " + idDetailComposant + " does not exist.");
        }
    }
@Operation(summary = "Supprimer un détail de composant", description = "Supprime un détail de composant de la base de données en fonction de son ID.")
    @DeleteMapping("/deleteDetailComposant/{idDetailComposant}")
    public void deleteDetailComposant(@PathVariable Long idDetailComposant){
        detailComposantInterface.removeDetail(idDetailComposant);
    }










}

package tn.esprit.twin.projetsc2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Restauration;
import tn.esprit.twin.projetsc2.services.RestaurationInterface;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restauration")
//documentation
@Tag(name = "Gestion des Restaurations ", description = "Opérations liées aux restaurations")
public class RestaurationC {
    @Autowired
    RestaurationInterface restaurationInterface;

    @Operation(summary = "Ajouter une nouvelle restauration", description = "Cette opération permet d'ajouter une nouvelle restauration à la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restauration créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })

    @PostMapping("/addRestauration")
    public Restauration addRestauration(@RequestBody Restauration restauration){
        return restaurationInterface.addRestauration(restauration);
    }

    @Operation(summary = "Ajouter plusieurs restaurations", description = "Ajoute une liste de restaurations dans le système")
    @PostMapping("/addListRestauration")
    public List<Restauration> addListRestauration(@RequestBody List<Restauration> restaurations){
        return restaurationInterface.addRestaurations(restaurations);
    }
    @Operation(summary = "Récupérer toutes les restaurations", description = "Retourne la liste de toutes les restaurations")
    @GetMapping("/getAllRestaurations")
    public List<Restauration> getAllRestaurations(){
        return restaurationInterface.retrieveAllRestaurations();
    }
    @Operation(summary = "Récupérer une restauration par ID")
    @GetMapping("/getRestauration/{idRestauration}")
    public Restauration getRestauration(@PathVariable Long idRestauration){
        return restaurationInterface.retrieveRestauration(idRestauration);
    }
    @Operation(summary = "Mettre à jour une restauration existante", description = "Met à jour les informations d'une restauration en fonction de son ID.")
    @PutMapping("/updateRestauration/{idRestauration}")
    public Restauration updateRestauration(@RequestBody Restauration restauration, @PathVariable Long idRestauration){
        Restauration r=restaurationInterface.retrieveRestauration(idRestauration);
        if (r!=null){
            r.setNom(restauration.getNom());
            r.setNbPlacesMax(restauration.getNbPlacesMax());

            return restaurationInterface.updateRestauration(r);
        } else {
            throw new IllegalArgumentException("Restauration with id " + idRestauration + " does not exist.");
        }

    }
    @Operation(summary = "Supprimer une restauration par ID", description = "Supprime une restauration spécifique en fonction de son ID.")
    @DeleteMapping("/deleteRestauration/{idRestauration}")
    public void deleteRestauration(@PathVariable Long idRestauration){
        restaurationInterface.removeRestauration(idRestauration);
    }


@Operation(summary = "Récupérer les restaurants avec un nombre de places maximum supérieur à une valeur donnée et une date de création avant une date spécifiée", description = "Cette opération permet de récupérer une liste de restaurants qui ont un nombre de places maximum supérieur à la valeur spécifiée et dont la chaîne de restauration a été créée avant la date donnée.")
    @GetMapping("/getRestaurantsNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore/{nbPlaces}/{dateCreation}")
    public List<Restauration> getRestaurantsNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(@PathVariable Long nbPlaces, @PathVariable String dateCreation){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(dateCreation, formatter);
          return restaurationInterface.getRestaurantsNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(nbPlaces, parsedDate);
        } catch (Exception e) {
            throw new RuntimeException("Format de date invalide. Utilisez 'yyyy-MM-dd'.");
        }

    }

/*****Affectation *************/

@GetMapping("/affecterRestaurantAChaineRestauration/{nom}/{idChaine}" )
    public Restauration affecterRestaurantAChaineRestauration(@PathVariable("nom") String nom, @PathVariable("idChaine") Long idChaine ){
        return restaurationInterface.affecterRestaurantAChaineRestauration(nom, idChaine);
    }

    @PostMapping("/ajoutRestaurantEtMenuAssocies")
    public Restauration ajoutRestaurantEtMenuAssocies(@RequestBody Restauration restaurant){
        return restaurationInterface.ajoutRestaurantEtMenuAssocies(restaurant);
    }


}

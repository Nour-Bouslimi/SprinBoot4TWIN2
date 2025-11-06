package tn.esprit.twin.projetsc2.controller;

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
public class RestaurationC {
    @Autowired
    RestaurationInterface restaurationInterface;

    @PostMapping("/addRestauration")
    public Restauration addRestauration(@RequestBody Restauration restauration){
        return restaurationInterface.addRestauration(restauration);
    }

    @PostMapping("/addListRestauration")
    public List<Restauration> addListRestauration(@RequestBody List<Restauration> restaurations){
        return restaurationInterface.addRestaurations(restaurations);
    }

    @GetMapping("/getAllRestaurations")
    public List<Restauration> getAllRestaurations(){
        return restaurationInterface.retrieveAllRestaurations();
    }
    @GetMapping("/getRestauration/{idRestauration}")
    public Restauration getRestauration(@PathVariable Long idRestauration){
        return restaurationInterface.retrieveRestauration(idRestauration);
    }
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
    @DeleteMapping("/deleteRestauration/{idRestauration}")
    public void deleteRestauration(@PathVariable Long idRestauration){
        restaurationInterface.removeRestauration(idRestauration);
    }

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





}

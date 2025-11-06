package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.DetailComposant;
import tn.esprit.twin.projetsc2.services.DetailComposantInterface;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detailComposant")
public class DetailComposantC {
    @Autowired
    DetailComposantInterface detailComposantInterface;

    @PostMapping("/addDetailComposant")
    public DetailComposant addDetailComposant(@RequestBody DetailComposant detailComposant){
        return detailComposantInterface.addDetail(detailComposant);
    }
    @PostMapping("/addListDetailComposants")
    public List<DetailComposant> addListDetailComposants(@RequestBody List<DetailComposant> detailComposants){
        return detailComposantInterface.addDetails(detailComposants);
    }
    @GetMapping("/getAllDetailComposants")
    public List<DetailComposant> getAllDetailComposants(){
        return detailComposantInterface.retrieveAlldetails();
    }

    @GetMapping("/getDetailComposantById/{idDetailComposant}")
    public DetailComposant getDetailComposantById(@PathVariable Long idDetailComposant){
        return detailComposantInterface.retrieveDetail(idDetailComposant);
    }

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

    @DeleteMapping("/deleteDetailComposant/{idDetailComposant}")
    public void deleteDetailComposant(@PathVariable Long idDetailComposant){
        detailComposantInterface.removeDetail(idDetailComposant);
    }










}

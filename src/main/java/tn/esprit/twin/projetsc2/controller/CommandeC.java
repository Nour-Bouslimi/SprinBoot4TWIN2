package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.services.CommandeInterface;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/commande")
public class CommandeC {
    @Autowired
    CommandeInterface commandeInterface;

    @PostMapping("/addCommande")
    public Commande addCommande(Commande commande){
        return commandeInterface.addCommande(commande);
    }
    @PostMapping("/addListCommandes")
    public List<Commande> addListCommandes(@RequestBody List<Commande> commandes){
        return commandeInterface.addCommandes(commandes);
    }
    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes(){
        return commandeInterface.retrieveAllCommandes();
    }

    @GetMapping("/getCommandeById/{idCommande}")
    public Commande getCommandeById(Long idCommande){
        return commandeInterface.retrieveCommande(idCommande);
    }

    @PutMapping("/updateCommande/{idCommande}")
    public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long idCommande){
        Commande cmd=commandeInterface.retrieveCommande(idCommande);
        if(cmd!=null){
       cmd.setDateCommande(commande.getDateCommande());
           cmd.setClient(commande.getClient());
           cmd.setNote(commande.getNote());
           cmd.setTotalCommande(commande.getTotalCommande());
           cmd.setPourcentageRemise(commande.getPourcentageRemise());
           cmd.setTotalRemise(commande.getTotalRemise());

            return commandeInterface.updateCommande(cmd,idCommande);

        } else {
            throw new IllegalArgumentException("Annonce with id " + idCommande + " does not exist.");
        }
    }

    @DeleteMapping("/deleteCommande/{idCommande}")
    public void deleteCommande(@PathVariable Long idCommande){
        commandeInterface.removeCommande(idCommande);
    }
    @GetMapping("/getByClientIdClient/{idClient}")
    public List<Commande> getByClientIdClient(@PathVariable Long idClient){
        return commandeInterface.getByClientIdClient(idClient);
    }
    @GetMapping("/getByClientIdClientAndDateCommandeBetween/{idClient}/{startDate}/{endDate}")
    public List<Commande> getByClientIdClientAndDateCommandeBetween(@PathVariable Long idClient, @PathVariable String startDate, @PathVariable String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return commandeInterface.getByClientIdClientAndDateCommandeBetween(idClient, start, end);
    }
    @GetMapping("/getByDateCommandeBetweenOrderByNoteDesc/{startDate}/{endDate}")
    public List<Commande> getByDateCommandeBetweenOrderByNoteDesc(@PathVariable String startDate, @PathVariable String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return commandeInterface.getByDateCommandeBetweenOrderByNoteDesc(start, end);
    }




}

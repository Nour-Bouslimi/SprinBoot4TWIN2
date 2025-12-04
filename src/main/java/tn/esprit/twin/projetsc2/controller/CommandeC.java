package tn.esprit.twin.projetsc2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.services.CommandeDTO;
import tn.esprit.twin.projetsc2.services.CommandeInterface;
import tn.esprit.twin.projetsc2.services.CommandeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/commande")
@Tag(name = "Gestion des Commandes", description = "Opérations liées aux commandes")
public class CommandeC {

    CommandeInterface commandeInterface;
    CommandeService commandeService;
@Operation(summary = "Ajouter une nouvelle commande", description = "Cette opération permet d'ajouter une nouvelle commande à la base de données.")
    @PostMapping("/addCommande")
    public Commande addCommande(@RequestBody Commande commande){
        return commandeInterface.addCommande(commande);
    }
    @Operation(summary = "ajouter une liste des commandes " , description = "cette operation permet d'ajouter une liste des commandes a la base de données")
    @PostMapping("/addListCommandes")
    public List<Commande> addListCommandes(@RequestBody List<Commande> commandes){
        return commandeInterface.addCommandes(commandes);
    }
    @Operation(summary = "récupérer les commandes")
    @GetMapping("/getAllCommandes")
    public List<Commande> getAllCommandes(){
        return commandeInterface.retrieveAllCommandes();
    }
@Operation(summary = "récupérer une commande par son id")
    @GetMapping("/getCommandeById/{idCommande}")
    public Commande getCommandeById(@PathVariable Long idCommande){
        return commandeInterface.retrieveCommande(idCommande);
    }

    @Operation(summary = "modifier une commande")
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
@Operation(summary = "supprimer une commande")
    @DeleteMapping("/deleteCommande/{idCommande}")
    public void deleteCommande(@PathVariable Long idCommande){
        commandeInterface.removeCommande(idCommande);
    }
    @GetMapping("/getByClientIdClient/{idClient}")
    public List<Commande> getByClientIdClient(@PathVariable Long idClient){
        return commandeInterface.getByClientIdClient(idClient);
    }
    @Operation(summary = "Récupérer les commandes d'un client entre deux dates")
    @GetMapping("/getByClientIdClientAndDateCommandeBetween/{idClient}/{startDate}/{endDate}")
    public List<Commande> getByClientIdClientAndDateCommandeBetween(@PathVariable Long idClient, @PathVariable String startDate, @PathVariable String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return commandeInterface.getByClientIdClientAndDateCommandeBetween(idClient, start, end);
    }
    @Operation(summary = "Récupérer les commandes entre deux dates, triées par note décroissante")
    @GetMapping("/getByDateCommandeBetweenOrderByNoteDesc/{startDate}/{endDate}")
    public List<Commande> getByDateCommandeBetweenOrderByNoteDesc(@PathVariable String startDate, @PathVariable String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return commandeInterface.getByDateCommandeBetweenOrderByNoteDesc(start, end);
    }
@Operation(summary = "Ajouter une commande et l'affecter à un client et un menu")
@PostMapping("/ajouterCommandeEtAffecterAClientEtMenu/{identifiant}/{libelleMenu}")
    public void ajouterCommandeEtAffecterAClientEtMenu(@RequestBody Commande commande, @PathVariable String identifiant, @PathVariable String libelleMenu){
        commandeInterface.ajouterCommandeEtAffecterAClientEtMenu(commande, identifiant, libelleMenu);
    }

    @GetMapping("/getCommandesByClientAndMenu/{identifiant}/{libelleMenu}")
    public List<CommandeDTO> getCommandesByClientAndMenu(@PathVariable String identifiant, @PathVariable String libelleMenu){
        return commandeService.listeCommandesParClientEtMenu(identifiant, libelleMenu);
    }


}

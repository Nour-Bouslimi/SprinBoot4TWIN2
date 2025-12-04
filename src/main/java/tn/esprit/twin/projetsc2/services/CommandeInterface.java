package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeInterface {
    List<Commande> retrieveAllCommandes();
    public Commande retrieveCommande(Long idCommande);
    Commande addCommande(Commande c);
    Commande updateCommande(Commande c,Long idCommande);
    void removeCommande(Long idCommande);
    List<Commande> addCommandes(List<Commande> commandes);
    List<Commande> getByClientIdClient(Long idClient);
    List<Commande> getByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate startDate, LocalDate endDate);
    List<Commande>getByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);
    void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu);

    //scheduler
    void findCurrentYearCommandesOrderByNote();
    //scheduler
    void menuPlusCommande();
    //dto
    List<CommandeDTO> listeCommandesParClientEtMenu(String identifiant, String libelleMenu);

}

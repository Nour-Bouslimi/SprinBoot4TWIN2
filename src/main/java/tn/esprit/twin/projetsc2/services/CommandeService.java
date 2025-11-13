package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.repository.ClientRepo;
import tn.esprit.twin.projetsc2.repository.CommandeRepo;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class CommandeService implements CommandeInterface {

    private CommandeRepo commandeRepo;
    private ClientRepo clientRepo;
    private MenuRepo menuRepo;
    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepo.findAll();
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        return commandeRepo.findById(idCommande).orElse(null);
    }

    @Override
    public Commande addCommande(Commande c) {
        return commandeRepo.save(c);
    }

    @Override
    public Commande updateCommande(Commande c, Long idCommande) {
        c.setIdCommande(idCommande);
        return commandeRepo.save(c);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepo.deleteById(idCommande);
    }

    @Override
    public List<Commande> addCommandes(List<Commande> commandes) {
        return commandeRepo.saveAll(commandes);
    }

    @Override
    public List<Commande> getByClientIdClient(Long idClient) {
        return commandeRepo.findByClientIdClient(idClient);
    }

    @Override
    public List<Commande> getByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate startDate, LocalDate endDate) {
        return commandeRepo.findByClientIdClientAndDateCommandeBetween(idClient, startDate, endDate);
    }

    @Override
    public List<Commande> getByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate) {
        return commandeRepo.findByDateCommandeBetweenOrderByNoteDesc(startDate, endDate);
    }

    @Override
    public void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client client = clientRepo.findByIdentifiant(identifiant);
        Menu menu = menuRepo.findByLibelleMenu(libelleMenu);
        if(client != null && menu != null){
            // Le total commande et le total remise est calculable selon le prix du menu envoyé et le
            //pourcentage de la remise
            float totalCommande = menu.getPrixTotal();
            commande.setTotalCommande(totalCommande);
            float totalRemise = (commande.getPourcentageRemise() / 100.0f) * totalCommande;
            commande.setTotalRemise(totalRemise);
            commande.setClient(client);
            commande.setMenu(menu);
            commandeRepo.save(commande);
        }
    }
}

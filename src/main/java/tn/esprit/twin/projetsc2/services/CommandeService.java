package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.repository.ClientRepo;
import tn.esprit.twin.projetsc2.repository.CommandeRepo;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CommandeService implements CommandeInterface {

    private CommandeRepo commandeRepo;
    private ClientRepo clientRepo;
    private MenuRepo menuRepo;
    private CommandeMapper commandeMapper;
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

    @Override
    @Scheduled(cron = "*/30 * * * * ?")
    public void findCurrentYearCommandesOrderByNote() {
       LocalDate startDate= LocalDate.of(LocalDate.now().getYear(),1,1);
         LocalDate endDate= LocalDate.of(LocalDate.now().getYear(),12,31);
         List<Commande> commandes=commandeRepo.findByDateCommandeBetweenOrderByNoteDesc(startDate,endDate);
         for(Commande c:commandes){
             log.info("La commande faite le " + c.getDateCommande() + "d'un montant global de " + c.getTotalCommande() + "a une note de " + c.getNote());
         }

    }

    @Override
    @Scheduled(cron = "*/15 * * * * ?") // Exécute la tâche tous les jours à minuit
    public void menuPlusCommande() {

        List<Object[]> results = commandeRepo.menuPlusCommande();
        if (!results.isEmpty()) {
            Object[] topMenu = results.get(0);
            String libelleMenu = (String) topMenu[0];
            Long count = (Long) topMenu[1];
            log.info("Le menu le plus commandé dans votre restaurant est  : " + libelleMenu + " commandé " + count + " fois.");
        } else {
            log.info("Aucune commande trouvée.");
        }

    }

    // liste des commandes correspondant à un client donné et un menu donné avec dto
    @Override
    public List<CommandeDTO> listeCommandesParClientEtMenu(String identifiant, String libelleMenu) {
        List<Commande> commandes= commandeRepo.findByClientIdentifiantAndMenuLibelleMenu(identifiant,libelleMenu);
        return commandeMapper.toDtoList(commandes);
    }

}

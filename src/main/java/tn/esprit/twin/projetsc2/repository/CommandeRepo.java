package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.services.CommandeDTO;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CommandeRepo  extends JpaRepository<Commande, Long> {
    List<Commande>findByClientIdClient(Long idClient);
    List<Commande>findByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate startDate, LocalDate endDate);
    List<Commande>findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);


    //nom du menu le plus commandé et le nombre de commandes pour un menu  avec JPQL
    @Query("SELECT c.menu.libelleMenu, COUNT(c) FROM Commande c GROUP BY c.menu.libelleMenu ORDER BY COUNT(c) DESC")
    List<Object[]> menuPlusCommande();

    @Query("select c.dateCommande , c.totalCommande , m.libelleMenu, cl.identifiant from Commande c join c.menu m join c.client cl where c.idCommande=?1")
    List<CommandeDTO> getCommandeByClientId(Long idCommande);
    // liste des commandes correspondant à un client donné et un menu donné
    List<Commande> findByClientIdentifiantAndMenuLibelleMenu(String identifiant, String libelleMenu);
}

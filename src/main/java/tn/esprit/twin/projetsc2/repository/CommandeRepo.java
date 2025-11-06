package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.entities.Commande;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CommandeRepo  extends JpaRepository<Commande, Long> {
    List<Commande>findByClientIdClient(Long idClient);
    List<Commande>findByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate startDate, LocalDate endDate);
    List<Commande>findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);

}

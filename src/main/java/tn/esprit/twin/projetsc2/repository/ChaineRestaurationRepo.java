package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
@Repository
public interface ChaineRestaurationRepo extends JpaRepository<ChaineRestauration, Long> {
}

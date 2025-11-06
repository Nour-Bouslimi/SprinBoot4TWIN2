package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.entities.DetailComposant;
@Repository
public interface DetailComposantRepo extends JpaRepository<DetailComposant, Long> {
}

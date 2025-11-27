package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;

public interface ChaineRestaurationRepo extends JpaRepository<ChaineRestauration, Long> {
    ChaineRestauration findByIdChaineRestauration(Long idChaineRestauration);
    ChaineRestauration findByLibelle(String libelleChaine);
    
}

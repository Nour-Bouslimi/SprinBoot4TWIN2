package tn.esprit.twin.projetsc2.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.entities.Client;

import java.util.List;

public interface ChaineRestaurationInterface   {
    List<ChaineRestauration> retrieveAllChaineRestauration();
    public ChaineRestauration retrieveChaineRestauration(Long idChaineRestauration);
    ChaineRestauration addChaineRestauration(ChaineRestauration c);
    ChaineRestauration updateChaineRestauration(ChaineRestauration c);
    void removeChaineRestauration(Long idChaineRestauration);
    List<ChaineRestauration> addChaineRestaurations(List<ChaineRestauration> ChaineRestaurations);
}

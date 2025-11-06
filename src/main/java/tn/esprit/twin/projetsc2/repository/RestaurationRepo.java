package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Restauration;
import tn.esprit.twin.projetsc2.entities.TypeChef;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface RestaurationRepo extends JpaRepository<Restauration, Long> {
    List<Restauration>findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, LocalDate dateCreation);

    //Liste chefs cuisinier 1 etoile d'un restaurant donné
    @Query("select  m from Restauration r join r.menus m join m.chefCuisiniers c where  r.idRestauration=?1 and c.typeChef=?2")
    List<ChefCuisinier>getChefsCuisiniers1EtoileByRestauration(Long idRestauration, TypeChef typeChef);

}

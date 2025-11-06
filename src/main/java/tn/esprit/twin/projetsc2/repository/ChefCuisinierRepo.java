package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChaineRestauration;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Restauration;

import java.util.List;

@Repository
public interface ChefCuisinierRepo extends JpaRepository<ChefCuisinier, Long> {

}

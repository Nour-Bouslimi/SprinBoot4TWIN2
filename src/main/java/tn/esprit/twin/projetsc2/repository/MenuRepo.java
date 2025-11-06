package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.ChefCuisinier;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.entities.TypeComposant;
import tn.esprit.twin.projetsc2.entities.TypeMenu;

import java.util.List;
@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    //liste des Menu par type Menu et dont le prix total des composants est supérieur à un montant donné avec key words
    List<Menu>findByTypeMenuAndComposantsPrixGreaterThan(TypeMenu typeMenu, float prixMin);

    //liste des noms des Menu par type Menu Ordonne par prix total décroissant avec JpQL
    @Query("select m.libelleMenu from Menu m where m.typeMenu=:typeMenu order by m.prixTotal desc")
    List<String>getMenuNamesByTypeMenuOrderByPrixTotalDesc(TypeMenu typeMenu);

    //liste des menus contenant un type composant spécifique avec JpQL
    @Query("select m from Menu m join m.composants c where c.detailComposant.typeComposant=?1")
    List<Menu>getMenusByTypeComposant(TypeComposant typeComposant);
}

package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idMenu;
    private String libelleMenu;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    private Float prixTotal;
    // Relation with commande
    @OneToMany(mappedBy = "menu" ,  fetch = FetchType.LAZY)
    private List<Commande> commandes;
    // Relation with composant
    @OneToMany(mappedBy = "menu" , fetch = FetchType.LAZY)
    private List<Composant> composants;
    // Relation with chef cuisinier
    @ManyToMany(mappedBy = "menus", fetch = FetchType.LAZY)
    private List<ChefCuisinier> chefCuisiniers;


}

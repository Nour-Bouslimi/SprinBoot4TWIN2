package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Restauration {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idRestauration;
    private String nom;
    private Long nbPlacesMax;

    // Relation with ChaineRestauration
    @ManyToOne
    private ChaineRestauration chaineRestauration;

    //relation with menu
    @OneToMany
    private List <Menu> menus;


}

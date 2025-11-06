package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Composant {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idComposant;
    private String nomComposant;
    private float prix;

// Relation with menu
   @ManyToOne
    private Menu menu;

   //relation with detailComposant
    @OneToOne
    private DetailComposant detailComposant;


}

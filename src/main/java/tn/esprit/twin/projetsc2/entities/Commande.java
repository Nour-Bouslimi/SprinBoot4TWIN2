package tn.esprit.twin.projetsc2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private LocalDate dateCommande;
    private Integer pourcentageRemise;
    private Float totalRemise;
    private Float totalCommande;
    private Long note;
    // Relation avec Client
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    // Relation avec Menu
    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;


}

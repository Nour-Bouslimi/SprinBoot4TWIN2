package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {
    LocalDate dateCommande;
    Float totalCommande;
    String libelleMenu;
    String identifiant;
}

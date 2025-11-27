package tn.esprit.twin.projetsc2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idChaineRestauration;
    private String libelle;
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chaineRestauration" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Restauration> restaurations;


}

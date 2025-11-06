package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetailComposant {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idDetailComposant;
    private float imc;
    @Enumerated(EnumType.STRING)
    private TypeComposant typeComposant;
}

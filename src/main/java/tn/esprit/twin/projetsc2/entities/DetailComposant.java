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

    public Long getIdDetailComposant() {
        return idDetailComposant;
    }

    public void setIdDetailComposant(Long idDetailComposant) {
        this.idDetailComposant = idDetailComposant;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public TypeComposant getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(TypeComposant typeComposant) {
        this.typeComposant = typeComposant;
    }
}

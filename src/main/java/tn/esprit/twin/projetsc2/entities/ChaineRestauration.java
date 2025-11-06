package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idChaineRestauration;
    private String libelle;
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chaineRestauration" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Restauration> restaurations;

    public Long getIdChaineRestauration() {
        return idChaineRestauration;
    }

    public void setIdChaineRestauration(Long idChaineRestauration) {
        this.idChaineRestauration = idChaineRestauration;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Restauration> getRestaurations() {
        return restaurations;
    }

    public void setRestaurations(List<Restauration> restaurations) {
        this.restaurations = restaurations;
    }
}

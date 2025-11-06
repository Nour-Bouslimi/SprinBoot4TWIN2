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

    public Long getIdComposant() {
        return idComposant;
    }

    public void setIdComposant(Long idComposant) {
        this.idComposant = idComposant;
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public void setNomComposant(String nomComposant) {
        this.nomComposant = nomComposant;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public DetailComposant getDetailComposant() {
        return detailComposant;
    }

    public void setDetailComposant(DetailComposant detailComposant) {
        this.detailComposant = detailComposant;
    }
}

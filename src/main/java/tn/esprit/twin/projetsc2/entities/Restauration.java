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
    @OneToMany(cascade = CascadeType.ALL)
    private List <Menu> menus;

    public Long getIdRestauration() {
        return idRestauration;
    }

    public void setIdRestauration(Long idRestauration) {
        this.idRestauration = idRestauration;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNbPlacesMax() {
        return nbPlacesMax;
    }

    public void setNbPlacesMax(Long nbPlacesMax) {
        this.nbPlacesMax = nbPlacesMax;
    }

    public ChaineRestauration getChaineRestauration() {
        return chaineRestauration;
    }

    public void setChaineRestauration(ChaineRestauration chaineRestauration) {
        this.chaineRestauration = chaineRestauration;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

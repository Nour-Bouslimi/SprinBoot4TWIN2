package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idMenu;
    private String libelleMenu;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    private Float prixTotal;
    // Relation with commande
    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private List<Commande> commandes;
    // Relation with composant
    @OneToMany(mappedBy = "menu" , fetch = FetchType.LAZY)
    private List<Composant> composants;
    // Relation with chef cuisinier
    @ManyToMany(mappedBy = "menus", fetch = FetchType.LAZY)
    private List<ChefCuisinier> chefCuisiniers;

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getLibelleMenu() {
        return libelleMenu;
    }

    public void setLibelleMenu(String libelleMenu) {
        this.libelleMenu = libelleMenu;
    }

    public TypeMenu getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(TypeMenu typeMenu) {
        this.typeMenu = typeMenu;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public List<ChefCuisinier> getChefCuisiniers() {
        return chefCuisiniers;
    }

    public void setChefCuisiniers(List<ChefCuisinier> chefCuisiniers) {
        this.chefCuisiniers = chefCuisiniers;
    }
}

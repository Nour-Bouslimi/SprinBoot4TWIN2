package tn.esprit.twin.projetsc2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonIgnore
    @JoinColumn(name = "idClient")
    private Client client;
    // Relation avec Menu
    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getPourcentageRemise() {
        return pourcentageRemise;
    }

    public void setPourcentageRemise(Integer pourcentageRemise) {
        this.pourcentageRemise = pourcentageRemise;
    }

    public Float getTotalRemise() {
        return totalRemise;
    }

    public void setTotalRemise(Float totalRemise) {
        this.totalRemise = totalRemise;
    }

    public Float getTotalCommande() {
        return totalCommande;
    }

    public void setTotalCommande(Float totalCommande) {
        this.totalCommande = totalCommande;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

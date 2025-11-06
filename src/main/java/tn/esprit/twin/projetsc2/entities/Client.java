package tn.esprit.twin.projetsc2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity ye5dem kima ya3ref
    @Column(name = "idClient") //nsamyh ch n7eb
    private Long idClient;
    private String identifiant;
    @Temporal(TemporalType.DATE) //n7otouhe ken m3a type Date
    private Date datePremiereVisite;

@Transient // ma3neha l'attribut hedha ma t7ottouch fyl BD
    Integer difference;

    @OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY) // mappedBy bech t3ayet lel attribut client fil classe Commande , cascade = CascadeType.ALL : bech ki nfas5ou client yfasa5 zeda les commandes mte3ou , Les annonces ne sont chargées qu’à la demande (lazy loading).
    private List<Commande> commandes;
}

package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Commande;

import java.util.List;

public interface CommandeInterface {
    List<Commande> retrieveAllCommandes();
    public Commande retrieveCommande(Long idCommande);
    Commande addCommande(Commande c);
    Commande updateCommande(Commande c);
    void removeCommande(Long idCommande);
    List<Commande> addCommandes(List<Commande> commandes);
}

package tn.esprit.twin.projetsc2.services;

import tn.esprit.twin.projetsc2.entities.Client;

import java.util.List;

public interface ClientInterface {
    List<Client> retrieveAllClients();
    public Client retrieveClient(Long idClient);
    Client addClient(Client c);
    Client updateClient(Client c);
    void removeClient(Long idClient);
    List<Client> addClients(List<Client> clients);


}

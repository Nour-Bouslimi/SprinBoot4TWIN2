package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.repository.ClientRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientService implements ClientInterface {

    private ClientRepo clientRepo;
    @Override
    public List<Client> retrieveAllClients() {
        return clientRepo.findAll();

    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepo.findById(idClient).orElse(null);
    }

    @Override
    public Client addClient(Client c) {

        return clientRepo.save(c);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepo.save(c);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepo.deleteById(idClient);

    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return clientRepo.saveAll(clients);
    }
}

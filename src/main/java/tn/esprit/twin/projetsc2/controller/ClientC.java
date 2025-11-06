package tn.esprit.twin.projetsc2.controller;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.services.ClientInterface;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientC {
    @Autowired
    ClientInterface clientInterface;


    @PostMapping("/addClient")
    public Client addClient(Client client){
        return clientInterface.addClient(client);
    }

    @PostMapping("/addListClients")
    public List<Client> addListClients(List<Client> clients){
        return clientInterface.addClients(clients);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return clientInterface.retrieveAllClients();
    }
    @GetMapping("/getClientById/{idClient}")
    public Client getClientById(Long idClient){
        return clientInterface.retrieveClient(idClient);
    }

    @PutMapping("/updateClient/{idClient} ")
    public Client updateClient(Client client, Long idClient){
        Client c=clientInterface.retrieveClient(idClient);
        if(c!=null){
            c.setIdentifiant(client.getIdentifiant());
            c.setDatePremiereVisite(client.getDatePremiereVisite());


            return clientInterface.updateClient(c,idClient);
        } else {
            throw new IllegalArgumentException("Client with id " + idClient + " does not exist.");
        }
    }

    @DeleteMapping("/deleteClient/{idClient}")
    public void deleteClient(Long idClient){
        clientInterface.removeClient(idClient);
    }













}

package tn.esprit.twin.projetsc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin.projetsc2.entities.Client;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findByIdentifiant(String identifiant);




}

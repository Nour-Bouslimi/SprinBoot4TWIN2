package tn.esprit.twin.projetsc2.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.twin.projetsc2.services.ChaineRestaurationInterface;

@RestController
@AllArgsConstructor
public class ChaineRestaurationC {
     ChaineRestaurationInterface chaineRestaurationInterface;
}

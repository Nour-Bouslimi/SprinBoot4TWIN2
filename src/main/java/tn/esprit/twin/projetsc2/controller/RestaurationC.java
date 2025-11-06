package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.twin.projetsc2.services.RestaurationInterface;

@RestController
@AllArgsConstructor
public class RestaurationC {
    RestaurationInterface restaurationInterface;
}

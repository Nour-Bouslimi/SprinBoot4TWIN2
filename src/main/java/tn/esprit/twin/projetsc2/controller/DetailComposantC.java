package tn.esprit.twin.projetsc2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.twin.projetsc2.services.DetailComposantInterface;

@RestController
@AllArgsConstructor
public class DetailComposantC {
    DetailComposantInterface detailComposantInterface;
}

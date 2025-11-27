package tn.esprit.twin.projetsc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetSc2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSc2Application.class, args);
    }

}

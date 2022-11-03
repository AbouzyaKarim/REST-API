package com.sid.msbanque;

import com.sid.msbanque.entities.Client;
import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.TypeCompte;
import com.sid.msbanque.repositories.ClientRepository;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration, ClientRepository clientRepository){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            restConfiguration.exposeIdsFor(Client.class);
            Client c1=clientRepository.save(new Client(null,"Hassan",null));
            Client c2=clientRepository.save(new Client(null,"Ahmed",null));


            compteRepository.save(new Compte(0,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(0,Math.random()*9000,new Date(), TypeCompte.COURANT,c1));
            compteRepository.save(new Compte(0,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c2));
            compteRepository.findAll().forEach(c-> {System.out.println(c.getSolde());});
        };
    }
}

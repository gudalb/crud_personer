package com.example.crud_personer;

import com.example.crud_personer.domain.Person;
import com.example.crud_personer.repository.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudPersonerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudPersonerApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(PersonRepo personRepo) {

        return args -> {

            if(personRepo.findAll().size() < 1) {
                personRepo.save(new Person("Albin Gudmundsson", "Mörbyvägen 32b", "email1@email.se",
                        "49234982384", "004020342"));
                personRepo.save(new Person("Alf Fred", "Vägen 1", "email3@email.se",
                        "45345345", "5645635356"));
                personRepo.save(new Person("Uggla Svensson", "Väg 14", "email9@email.se",
                        "8765843", "2342526"));
            }

        };

    }

}


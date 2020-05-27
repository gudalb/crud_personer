package com.example.crud_personer.service;

import com.example.crud_personer.domain.Person;
import com.example.crud_personer.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    public List<Person> listAllPersons(){
        return personRepo.findAll();
    }

    public Optional<Person> findById(Long id) {return personRepo.findById(id);}

    @Transactional
    public void save(Person person){ personRepo.save(person);}

    @Transactional
    public void delete(Long id){ personRepo.deleteById(id);}
}

package com.example.crud_personer.controller;

import com.example.crud_personer.domain.Person;
import com.example.crud_personer.model.Response;
import com.example.crud_personer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PersonRESTController {

    PersonService personService;

    @Autowired
    public PersonRESTController(PersonService personService) {
        this.personService = personService;
    }



    @RequestMapping(value = "/delete_person/{id}", produces = "application/json")
    public Response removePerson(@PathVariable Long id) {

        Response response = new Response("person deleted:", false);
        Optional<Person> person = personService.findById(id);

        if(person.isPresent()) {
            personService.delete(id);
            response.setStatus(true);
        }

        return response;
    }

    @RequestMapping("/find_person/{id}")
    public Person findPerson(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);

        if(person.isPresent()) {

            Person personTemp = person.get();

            if(!personTemp.hasLink("all_person")){
                Link link = WebMvcLinkBuilder.linkTo(methodOn(PersonRESTController.class).getPersonList()).withRel("all_person");
                personTemp.add(link); }
            if(!personTemp.hasLink("remove_person")){
                Link link = WebMvcLinkBuilder.linkTo(methodOn(PersonRESTController.class).removePerson(personTemp.getId())).withRel("remove_person");
                personTemp.add(link); }
            if(!personTemp.hasLink("add_person")){
                Link link = WebMvcLinkBuilder.linkTo(methodOn(PersonRESTController.class).addPerson(personTemp)).withRel("add_person");
                personTemp.add(link); }


            return person.get();
        }

        return null;
    }

    @RequestMapping("/list_person")
    public List<Person> getPersonList() {
        return personService.listAllPersons();
    }


    @PostMapping("/add_person")
    public Response addPerson(@RequestBody Person person) {
        Response response = new Response("person added:", true);
        personService.save(person);

        return response;
    }
}







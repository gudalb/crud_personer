package com.example.crud_personer.controller;

import com.example.crud_personer.domain.Person;
import com.example.crud_personer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        List<Person> personList = personService.listAllPersons();
        model.addAttribute("all_persons", personList);
        return "index";
    }

    @GetMapping("/new")
    public String getNewPersonPage(Model model){
        Person person = new Person();
        model.addAttribute("newPerson", person);
        return "new_person";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model){

        Optional<Person> person = personService.findById(id);

        if(person.isPresent()) {
            model.addAttribute("person_to_edit", person.get());
            return "edit_person";
        }

        return "error";
    }

    @PostMapping("/save")
    public String savePerson(Person person, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "error";

        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id, Model model){

        Optional<Person> person = personService.findById(id);

        if(person.isPresent()) {
            personService.delete(id);
            return "redirect:/";
        }

        return "error";
    }
}

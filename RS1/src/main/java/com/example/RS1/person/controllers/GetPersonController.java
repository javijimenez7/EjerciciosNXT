package com.example.RS1.person.controllers;

import com.example.RS1.person.domain.model.Person;
import com.example.RS1.person.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class GetPersonController {
    @Autowired
    PersonService personService;

    @Autowired
    @Qualifier("persona")
    Person person;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> GetById(@PathVariable Integer id) {

        Person p = personService.findById(id);
        return ResponseEntity.ok(p);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Person> GetByName(@PathVariable String name) {

        Person person = personService.findByName(name);
        return ResponseEntity.ok(person);
    }
}

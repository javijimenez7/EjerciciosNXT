package com.example.RS1.person.controllers;

import com.example.RS1.person.domain.model.Person;
import com.example.RS1.person.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class AddPersonController {

    @Autowired
    PersonService personService;

    @Autowired
    @Qualifier("persona")
    Person person;

    @PostMapping()
    public ResponseEntity<List> addPerson(@RequestBody Person p){
        personService.getPeople().add(p);

        return ResponseEntity.ok(personService.getPeople());
    }

}

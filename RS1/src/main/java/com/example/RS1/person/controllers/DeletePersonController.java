package com.example.RS1.person.controllers;

import com.example.RS1.person.domain.model.Person;
import com.example.RS1.person.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/persona")
public class DeletePersonController {
    @Autowired
    PersonService personService;

    @Autowired
    @Qualifier("persona")
    Person person;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> DeletePerson(@PathVariable Integer id){

        personService.getPeople().removeIf(person -> Objects.equals(person.getId(), id));


        return ResponseEntity.ok("Eliminado");
    }

}

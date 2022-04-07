package com.example.RS1.person.controllers;

import com.example.RS1.person.domain.model.Person;
import com.example.RS1.person.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ModifiedPersonController {

    @Autowired
    PersonService personService;

    @Autowired
    @Qualifier("persona")
    Person person;

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> modifiedPerson(@PathVariable Integer id, @RequestBody Person person){

        Person personToModified = personService.findById(id);

        if(person.getName()!=null){
            personToModified.setName(person.getName());
        }

        if(person.getPopulation()!=null){
            personToModified.setPopulation(person.getPopulation());
        }

        if(person.getAge()!=null){
            personToModified.setAge(person.getAge());
        }

        return ResponseEntity.ok("Enviado");
    }
}

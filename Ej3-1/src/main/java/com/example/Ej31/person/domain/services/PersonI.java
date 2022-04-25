package com.example.Ej31.person.domain.services;

import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.person.infraestructure.dto.PersonInputDTO;
import com.example.Ej31.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonI {

    PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;


    Optional<Person> findById(String id);

    List<Person> findAll();


    ResponseEntity<?> deletedById(String id) throws Exception;
}

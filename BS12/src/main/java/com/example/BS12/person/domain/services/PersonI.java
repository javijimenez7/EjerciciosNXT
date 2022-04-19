package com.example.BS12.person.domain.services;

import com.example.BS12.person.domain.models.Person;
import com.example.BS12.person.infraestructure.dto.PersonInputDTO;
import com.example.BS12.person.infraestructure.dto.PersonOutputDTO;

import java.util.List;

public interface PersonI {

    PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;


    PersonOutputDTO findById(String id) throws Exception;

    List<Person> findAll();



    String deletedById(Integer id) throws Exception;
}

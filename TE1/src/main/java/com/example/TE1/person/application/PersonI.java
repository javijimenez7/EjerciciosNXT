package com.example.TE1.person.application;

import com.example.TE1.person.domain.Person;
import com.example.TE1.person.infraestructure.dto.PersonInputDTO;
import com.example.TE1.person.infraestructure.dto.PersonOutputDTO;

import java.util.List;

public interface PersonI {

    PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;


    PersonOutputDTO findById(String id) throws Exception;

    List<PersonOutputDTO> findAll();


    Person deletedById(String id) throws Exception;
}

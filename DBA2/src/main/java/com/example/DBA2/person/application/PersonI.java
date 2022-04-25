package com.example.DBA2.person.application;

import com.example.DBA2.person.domain.Person;
import com.example.DBA2.person.infraestructure.dto.PersonInputDTO;
import com.example.DBA2.person.infraestructure.dto.PersonOutputDTO;

import java.util.List;

public interface PersonI {

    PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;


    PersonOutputDTO findById(String id) throws Exception;

    List<Person> findAll();



    String deletedById(Integer id) throws Exception;
}

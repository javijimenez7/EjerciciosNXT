package com.example.EJS31.person.infraestructure.repositories;


import com.example.EJS31.person.domain.models.Person;
import com.example.EJS31.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<PersonOutputDTO> findByUser(String user);

    List<PersonOutputDTO> findByName(String name);


}

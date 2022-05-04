package com.example.TE1.person.infraestructure.repositories;


import com.example.TE1.person.domain.Person;
import com.example.TE1.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<PersonOutputDTO> findByName(String name);


}

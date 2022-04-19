package com.example.BS9.person.domain.repositories;


import com.example.BS9.person.domain.models.Person;
import com.example.BS9.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<PersonOutputDTO> findByUser(String user);

}

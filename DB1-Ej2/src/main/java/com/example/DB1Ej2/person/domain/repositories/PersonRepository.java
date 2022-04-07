package com.example.DB1Ej2.person.domain.repositories;

import com.example.DB1Ej2.person.domain.models.Person;
import com.example.DB1Ej2.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<PersonOutputDTO> findByUser(String user);
}

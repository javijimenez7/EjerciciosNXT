package com.example.DBA1.person.infraestructure.repositories;


import com.example.DBA1.person.domain.Person;
import com.example.DBA1.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<PersonOutputDTO> findByUser(String user);

    List<Person> getData(HashMap<String, Object> conditions);
}

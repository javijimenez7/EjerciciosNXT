package com.example.DBA2.person.infraestructure.repositories;


import com.example.DBA2.person.domain.Person;
import com.example.DBA2.person.infraestructure.dto.PersonOutputDTO;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository {

    Person savePerson(Person person);
    List<Person> getAll();
    Person findOneById(String id);

    void deleteById(String id);

    void updatePerson(Person person, String id);
}

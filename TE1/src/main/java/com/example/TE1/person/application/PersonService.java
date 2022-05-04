package com.example.TE1.person.application;


import com.example.TE1.person.domain.Person;
import com.example.TE1.person.infraestructure.dto.PersonInputDTO;
import com.example.TE1.person.infraestructure.dto.PersonOutputDTO;
import com.example.TE1.person.infraestructure.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements PersonI {


    //repositorio person
    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception {

        Person person = new Person(personDTO);
        personRepository.save(person);
        PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);
        return saveOutputDTO;


    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception {
        try {
            List<PersonOutputDTO> peopleByName = personRepository.findByName(name);
            return peopleByName;
        } catch (Exception e) {
            throw new Exception("No se ha podido encontrar el usuario");
        }
    }

    @Override
    public PersonOutputDTO findById(String id) throws Exception {

        Person peopleById = personRepository.findById((id)).orElseThrow(() -> new Exception("No se ha encontrado"));
        return new PersonOutputDTO(peopleById);

    }

    @Override
    public List<PersonOutputDTO> findAll() {
        return personRepository.findAll().stream().map(PersonOutputDTO::new).collect(Collectors.toList());
    }

    @Override
    public Person deletedById(String id) throws Exception {
        Person p = personRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado a la persona cuyo id es: " + id));
        personRepository.deleteById(id);
        return p;
    }
}

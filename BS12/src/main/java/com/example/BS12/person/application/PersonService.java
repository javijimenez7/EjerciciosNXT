package com.example.BS12.person.application;


import com.example.BS12.person.application.mappers.PersonMapper;
import com.example.BS12.person.domain.Person;
import com.example.BS12.person.infraestructure.repositories.PersonRepository;
import com.example.BS12.person.infraestructure.dto.PersonInputDTO;
import com.example.BS12.person.infraestructure.dto.PersonOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonI {


    @Autowired
    private PersonRepository personRepository;



    @Override
    public PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception{

            Person person = PersonMapper.INSTANCE.PersonInputToPerson(personDTO);
            personRepository.save(person);
            PersonOutputDTO saveOutputDTO = PersonMapper.INSTANCE.PersonToPersonOutput(person);
            return saveOutputDTO;


    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception{
        try{
            List<PersonOutputDTO> peopleByName = personRepository.findByUser(name);
            return peopleByName;
        } catch(Exception e){
            throw new Exception("No se ha podido encontrar el usuario");
        }
    }

    @Override
    public PersonOutputDTO findById(String id) throws Exception{

        Person peopleById = personRepository.findById(Integer.parseInt(id)).orElseThrow(()-> new Exception("No se ha encontrado"));
        return new PersonOutputDTO(peopleById);

    }

    @Override
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Override
    public String deletedById(Integer id) throws Exception{
        personRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado a la persona cuyo id es: "+id));
        personRepository.deleteById(id);
        return "La persona cuyo es id es "+id+" ha sido borrada";
    }
}

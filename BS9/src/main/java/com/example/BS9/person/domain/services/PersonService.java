package com.example.BS9.person.domain.services;


import com.example.BS9.person.domain.repositories.PersonRepository;
import com.example.BS9.profesor.domain.repositories.ProfesorRepository;
import com.example.BS9.student.domain.repositories.StudentRepository;
import com.example.BS9.person.domain.models.Person;
import com.example.BS9.person.domain.repositories.PersonRepository;
import com.example.BS9.person.infraestructure.dto.PersonInputDTO;
import com.example.BS9.person.infraestructure.dto.PersonOutputDTO;
import com.example.BS9.profesor.domain.repositories.ProfesorRepository;
import com.example.BS9.student.domain.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonI {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception{
        if(personDTO.getUser().length()< 0 || personDTO.getUser().length()>10){
            throw new Exception("El usuario debe tener entre 0 y 10 caracteres");
        } else {
            Person person = new Person(personDTO);
            personRepository.save(person);
            PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);
            return saveOutputDTO;

        }
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

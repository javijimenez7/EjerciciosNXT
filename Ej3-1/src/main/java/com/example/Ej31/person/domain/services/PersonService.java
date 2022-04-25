package com.example.Ej31.person.domain.services;


import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.person.infraestructure.repositories.PersonRepository;
import com.example.Ej31.person.infraestructure.dto.PersonInputDTO;
import com.example.Ej31.person.infraestructure.dto.PersonOutputDTO;
import com.example.Ej31.profesor.infrastructure.repositories.ProfesorRepository;
import com.example.Ej31.student.infrastructure.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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
    public Optional<Person> findById(String id){

        return personRepository.findById(id);


    }

    @Override
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deletedById(String id) throws Exception {
        ResponseEntity respuesta = ResponseEntity.ok("Persona borrada");

        personRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado a la persona cuyo id es: " + id));

        if (profesorRepository.findByPersonId(id).isEmpty()) {
            if (studentRepository.findByPersonId(id).isEmpty()) {
                personRepository.deleteById(id);
            } else {
                respuesta = ResponseEntity.ok("No se puede borrar ya que la persona esta asociada a un estudiante");
            }
        } else {
            respuesta =  ResponseEntity.ok("No se puede borrar ya que la persona esta asociada a un profesor");
        }
            return respuesta;

    }
}

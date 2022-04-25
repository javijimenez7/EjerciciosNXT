package com.example.EJS31.profesor.domain.services;


import com.example.EJS31.person.domain.models.Person;
import com.example.EJS31.person.domain.services.PersonService;
import com.example.EJS31.profesor.domain.models.Profesor;
import com.example.EJS31.profesor.infrastructure.dto.InputProfesorDto;
import com.example.EJS31.profesor.infrastructure.repositories.ProfesorRepository;
import com.example.EJS31.student.infrastructure.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements ProfesorI {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonService personService;


    @Override
    public ResponseEntity<?> addProfesor(InputProfesorDto profesorDto) throws Exception {

        Optional<Person> person = personService.findById(profesorDto.getPerson());


        if (person.isPresent()) {
            Profesor profesor = new Profesor(profesorDto);
            profesor.setPerson(person.get());

            if (profesorRepository.findByPersonId(person.get().getPerson_id()).isEmpty() && studentRepository.findByPersonId(person.get().getPerson_id()).isEmpty()) {
                profesorRepository.save(profesor);
                return new ResponseEntity<>("Profesor guardado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error al insertar profesor, la persona ya esta asociada a un profesor", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Optional<Profesor> findById(String id) throws Exception {

        return profesorRepository.findById(id);

    }

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    public String deletedById(String id) throws Exception {
        profesorRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado al profesor cuyo id es: " + id));
        profesorRepository.deleteById(id);
        return "El profesor cuyo es id es " + id + " ha sido borrado";
    }
}

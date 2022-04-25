package com.example.DBA2.person.infraestructure;

import com.example.DBA2.person.domain.Person;
import com.example.DBA2.person.infraestructure.dto.PersonInputDTO;
import com.example.DBA2.person.infraestructure.dto.PersonOutputDTO;
import com.example.DBA2.person.infraestructure.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController

public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    //Request para añadir una persona a la base de datos

    @PostMapping(value = "/addperson")
    public String addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception{
        System.out.println("En el controlador addPerson");
        Person person = new Person(personInputDTO);
        personRepository.savePerson(person);
        return "Persona creada correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getall")
    public ResponseEntity getPeople() throws Exception{

        return ResponseEntity.ok(personRepository.getAll());

    }

    //Request para person by id
    @GetMapping(value = "/get/{id}")
    public ResponseEntity getPersonById(@PathVariable String id) throws Exception{

        Person p = personRepository.findOneById(id);
        PersonOutputDTO person = new PersonOutputDTO(p);
        return ResponseEntity.ok().body(p);
    }

    //Modifica person
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonById(@PathVariable String id, @RequestBody PersonInputDTO personInDto){
        Person p = new Person(personInDto);
        personRepository.updatePerson(p,id);
        return ResponseEntity.ok().body("Updated succesfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        personRepository.deleteById(id);
        return ResponseEntity.ok().body("Deleted succesfully");
    }

}

package com.example.TE1.person.infraestructure;

import com.example.TE1.person.application.PersonService;
import com.example.TE1.person.domain.Person;
import com.example.TE1.person.infraestructure.dto.PersonInputDTO;
import com.example.TE1.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController

public class PersonController {

    @Autowired
    private PersonService personService;


    //Request para añadir una persona a la base de datos

    // Request para insertar una persona en la base de datos
    @PostMapping("/addPerson")
    public PersonOutputDTO insertPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception {
        System.out.println("En el controlador addPerson");
        return personService.addPerson(personInputDTO);
    }

    // Request para obtener todos los registros de la tabla
    @GetMapping(value = "/getPeople")
    public List<PersonOutputDTO> getPeople() {
        System.out.println("En el controlador getPeople");
        return personService.findAll();
    }

    // Request para obtener la persona con id pasado por parámetro
    @GetMapping(value = "/getPerson/{id}")
    public PersonOutputDTO getPersonById(@PathVariable String id) throws Exception {
        return personService.findById(id);
    }

    // Request para eliminar la persona con id pasado por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public Person deletePersonById(@PathVariable String id) throws Exception {
        return personService.deletedById(id);
    }

    // Request para obtener la persona con nombre pasado por parámetro
    @GetMapping(value = "/getPeople/name/{name}")
    public List<PersonOutputDTO> getPeopleByName(@PathVariable String name) throws Exception {
        return personService.findByName(name);
    }

}

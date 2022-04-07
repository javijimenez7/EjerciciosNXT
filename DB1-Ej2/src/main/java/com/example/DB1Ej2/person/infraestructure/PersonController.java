package com.example.DB1Ej2.person.infraestructure;

import com.example.DB1Ej2.person.domain.models.Person;
import com.example.DB1Ej2.person.domain.repositories.PersonRepository;
import com.example.DB1Ej2.person.domain.services.PersonService;
import com.example.DB1Ej2.person.infraestructure.dto.PersonInputDTO;
import com.example.DB1Ej2.person.infraestructure.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception{
        System.out.println("En el controlador addPerson");
        personService.addPerson(person);
        return "Persona creada correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getPeople")
    public List<Person> getPeople(){
        System.out.println("En el controlador getPeople");
        return personService.findAll();
    }

    //Request para obtener la persona cuyo id se para por parámetro
    @GetMapping(value = "/getPerson/{id}")
    public PersonOutputDTO getPersonById(@PathVariable Integer id) throws Exception{
        return personService.findById(id);
    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public String deletePersonById(@PathVariable Integer id) throws Exception{
        personService.deletedById(id);
        return "La persona con id "+id+" ha sido eliminada de la base de datos";

    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @GetMapping(value = "/getPerson/name/{name}")
    public List<PersonOutputDTO> deletePersonById(@PathVariable String name) throws Exception{
        return personService.findByName(name);
    }

}

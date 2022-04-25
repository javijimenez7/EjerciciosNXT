package com.example.EJS31.person.infraestructure;

import com.example.EJS31.person.domain.services.PersonService;
import com.example.EJS31.person.infraestructure.dto.PersonInputDTO;
import com.example.EJS31.person.infraestructure.dto.PersonOutputDTO;
import com.example.EJS31.profesor.domain.services.ProfesorService;
import com.example.EJS31.student.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private StudentService studentService;


    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception{
        System.out.println("En el controlador addPerson");
        personService.addPerson(person);
        return "Persona creada correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getPeople")
    public ResponseEntity getPeople(@RequestParam(defaultValue = "simple") String outputType) throws Exception{
        System.out.println("En el controlador getPeople");

        if(outputType.equals("simple")){
            return ResponseEntity.ok(personService.findAll());
        } else {
            if(outputType.equals("full")){
                ;
            }
            return ResponseEntity.ok("No se ha encontrado");
        }
    }

    //Request para obtener la persona cuyo id se para por parámetro
    @GetMapping(value = "/getPerson/{id}")
    public PersonOutputDTO getPersonById(@PathVariable String id) throws Exception{
        return new PersonOutputDTO(personService.findById(id).get());
    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable String id) throws Exception{
        return personService.deletedById(id);

    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @GetMapping(value = "/getPerson/name/{name}")
    public List<PersonOutputDTO> deletePersonByName(@PathVariable String name) throws Exception{
        return personService.findByName(name);
    }

}

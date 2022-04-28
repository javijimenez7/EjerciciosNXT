package com.example.DBA1.person.infraestructure;

import com.example.DBA1.person.application.PersonService;
import com.example.DBA1.person.infraestructure.dto.PersonInputDTO;
import com.example.DBA1.person.infraestructure.repositories.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController

public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepositoryImpl personRepositoryImpl;

    //Request para añadir una persona a la base de datos

    @PostMapping(value = "/addperson")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception{
        System.out.println("En el controlador addPerson");
        personService.addPerson(person);
        return "Persona creada correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getall")
    public ResponseEntity getPeople() throws Exception{

        return ResponseEntity.ok(personService.findAll());

    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getallFilter")
    public ResponseEntity getPeopleFilter() throws Exception{

        HashMap<String,Object> hm= new HashMap<>();
        hm.put("name","pe");
        hm.put("orden","user");


        return ResponseEntity.ok(personRepositoryImpl.getData(hm));



    }

}

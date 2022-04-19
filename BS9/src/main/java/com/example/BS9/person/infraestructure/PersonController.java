package com.example.BS9.person.infraestructure;


import com.example.BS9.feign.IFeignServer;
import com.example.BS9.person.domain.services.PersonService;
import com.example.BS9.person.infraestructure.dto.PersonInputDTO;
import com.example.BS9.person.infraestructure.dto.PersonOutputDTO;
import com.example.BS9.profesor.domain.services.ProfesorService;
import com.example.BS9.profesor.infrastructure.dto.OutputProfesorDto;
import com.example.BS9.student.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private IFeignServer feignClient;


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

    //Llamada usando restControler
    @GetMapping("/profesor/{id}")
    public ResponseEntity<OutputProfesorDto> findProfesor(@PathVariable String id){
        ResponseEntity<OutputProfesorDto> rs = new RestTemplate().getForEntity("http://localhost:8081/profesor/getProfesor/"+id,OutputProfesorDto.class);
        return ResponseEntity.ok(rs.getBody());
    }


    @GetMapping("/feign/{id}")
    public ResponseEntity findProfesorUsingFeign(@PathVariable String id){
        ResponseEntity<OutputProfesorDto> profesor = feignClient.getProfesor(id);
        return ResponseEntity.ok(profesor.getBody());
    }

}
